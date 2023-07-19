package com.bawangbai.elastic.search.service.impl;

import com.bawangbai.elastic.search.pojo.es.Product;
import com.bawangbai.elastic.search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Override
    public void insert(Product product) {

    }

    //    @Autowired
//    private ProductDao productDao;

//    @Override
//    public void insert(Product product) {
//        productDao.save(product);
//    }

    @Override
    public void queryOrderTime() {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("distinct").field("category")
                .subAggregation(AggregationBuilders.topHits("category_top").size(1));
//        nativeSearchQueryBuilder.withAggregations(termsAggregationBuilder);
        nativeSearchQueryBuilder =nativeSearchQueryBuilder
                .withSort(SortBuilders.fieldSort("generateDateTime").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("generateTime").order(SortOrder.DESC))
        ;
        NativeSearchQuery build = nativeSearchQueryBuilder.build();
        SearchHits<Product> search = template.search(build, Product.class);
        for (SearchHit<Product> searchHit : search.getSearchHits()) {
//            log.info("获取数据：{}",searchHit.getContent());
        }
        if (search.hasAggregations()) {
//            AggregationsContainer<?> aggregations = search.getAggregations();
//            ElasticsearchAggregations aggregations1 = (ElasticsearchAggregations) aggregations;
//            ParsedStringTerms parsedStringTerms = aggregations1.aggregations().get("distinct");
//            List<? extends Terms.Bucket> buckets = parsedStringTerms.getBuckets();
//            for (Terms.Bucket bucket : buckets) {
//                String keyAsString = bucket.getKeyAsString();
//                log.info("info:{}",keyAsString);
//            }
        }
    }



}
