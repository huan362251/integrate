package com.jdbc.springdemo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import java.io.IOException;

public class EsAssembly {

    /**
     * 组合查询
     * must
     * should
     * 范围查询
     */

    public static void main(String[] args) throws IOException {
        aggregationGroupQuery();
    }

    /**
     * must查询，必须匹配上
     * @throws IOException
     */
    public static void mustQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.matchQuery("name","wangwu"));
        builder.query(boolQuery);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }


    /**
     * should查询，匹配or条件查询
     * @throws IOException
     */
    public static void shouldQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.should(QueryBuilders.matchQuery("age",30));
        boolQuery.should(QueryBuilders.matchQuery("age",40));
        builder.query(boolQuery);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

    /**
     * 范围查询
     * @throws IOException
     */
    public static void rangeQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age");
        rangeQueryBuilder.lte(40);
        rangeQueryBuilder.gt(30);
        builder.query(rangeQueryBuilder);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

    /**
     * 模糊查询
     */
    public static void fuzzyQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzziness = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE);
        builder.query(fuzziness);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

    /**
     * highLightQuery高亮查询
     * @throws IOException
     */
    public static void highLightQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "wangwu");
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color = 'red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");
        builder.highlighter(highlightBuilder);
        builder.query(termQueryBuilder);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

    /**
     * 聚合最大值抽取
     * @throws IOException
     */
    public static void aggregationMaxQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        MaxAggregationBuilder age = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(age);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

    /**
     * 聚合分组查询->分组不能分字符串，只能分数据？
     */
    public static void aggregationGroupQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermsAggregationBuilder field = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(field);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        client.close();
    }

}
