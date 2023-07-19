package com.bawangbai.elastic.search;

import com.bawangbai.elastic.search.esMapper.ProductDao;
import com.bawangbai.elastic.search.pojo.es.Product;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class ElasticSearchTest {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    private ProductDao productDao;

    @Test
    public void createProduct(){
        log.info("create product");
    }

    @Test
    public void deleteProduct(){
        boolean delete = template.indexOps(Product.class).delete();
        log.info("delete return flag:{}",delete);
    }

    @Test
    public void insertProduct(){
        Product product = new Product();
        product.setId(3L);
        product.setCategory("手机");
        product.setTitle("小米手机");
        product.setPrice(2354.3);
        product.setImages("https://www.hehe.com");
        productDao.save(product);
    }

    @Test
    public void updateProduct(){
        Product product = new Product();
        product.setId(3L);
        product.setCategory("手机");
        product.setTitle("小米手机");
        product.setPrice(2300.3);
        product.setImages("https://www.hehe.com");
        Product save = productDao.save(product);
        log.info("product:{}",save);
    }

    @Test
    public void deleteProductInfo(){
        productDao.deleteById(2L);
    }

    @Test
    public void bulkProduct(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i+10L);
            product.setCategory("手机");
            product.setTitle("小米手机"+i);
            product.setPrice(2300.3+i);
            product.setImages("https://www.hehe"+i+".com");
            list.add(product);
        }
        Iterable<Product> products = productDao.saveAll(list);
        log.info("return info:{}",products);
    }

    @Test
    public void findById(){
        Optional<Product> byId = productDao.findById(3L);
        Product product = byId.get();
        log.info("return product:{}",product);
    }

    @Test
    public void findAll(){
        Iterable<Product> all = productDao.findAll();
        all.forEach(product -> log.info("return product:{}",product));
    }

    @Test
    public void findSort(){
        Iterable<Product> id = productDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
        id.forEach(product -> log.info("return product:{}",product));
    }

    @Test
    public void findPage(){

    }

    @Test
    public void condition(){
        NativeSearchQuery a = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("title", "小米")).build();
        SearchHits<Product> search = template.search(a, Product.class);
        List<SearchHit<Product>> searchHits = search.getSearchHits();
        searchHits.forEach(info->log.info("result:{}",info));
        for (SearchHit<Product> searchHit : searchHits) {
            Product content = searchHit.getContent();
            log.info("product:{}",content);
        }




    }

}
