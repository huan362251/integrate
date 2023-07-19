package com.jdbc.springdemo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class EsDataBatch {

    public static void main(String[] args) throws IOException {
        insertBatch();
    }

    /**
     * 批量新增
     *
     * @throws IOException
     */
    public static void insertBatch() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.108", 9200, "http"))
        );
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user_demo").id("1001").source(XContentType.JSON, "name", "zhangsan","age",30));
        bulkRequest.add(new IndexRequest().index("user_demo").id("1002").source(XContentType.JSON, "name", "lisi","age",40));
        bulkRequest.add(new IndexRequest().index("user_demo").id("1003").source(XContentType.JSON, "name", "wangwu","age",50));
        bulkRequest.add(new IndexRequest().index("user_demo").id("1004").source(XContentType.JSON, "name", "zhangsan1","age",30));
        bulkRequest.add(new IndexRequest().index("user_demo").id("1005").source(XContentType.JSON, "name", "lisi1","age",40));
        bulkRequest.add(new IndexRequest().index("user_demo").id("1006").source(XContentType.JSON, "name", "wangwu1","age",50));
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
        client.close();
    }

    /**
     * 批量删除
     *
     * @throws IOException
     */
    public static void deleteBatch() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new DeleteRequest().index("user_demo").id("1001"));
        bulkRequest.add(new DeleteRequest().index("user_demo").id("1002"));
        bulkRequest.add(new DeleteRequest().index("user_demo").id("1003"));
        bulkRequest.add(new DeleteRequest().index("user_demo").id("DS78An8BBcwQdmW_J2fU"));
        bulkRequest.add(new DeleteRequest().index("user_demo").id("Di78An8BBcwQdmW_J2fU"));
        bulkRequest.add(new DeleteRequest().index("user_demo").id("Dy78An8BBcwQdmW_J2fU"));
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
        client.close();
    }

    public static void searchBatch() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        //SearchRequest searchRequest, RequestOptions options
        SearchRequest request = new SearchRequest().indices("user_demo");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
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
     * 条件查询
     * @throws IOException
     */
    public static void conditionQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );

        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("age",30));
        request.source(sourceBuilder);
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
     * 排序查询
     */
    public static void sortQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );

        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        query.sort("age", SortOrder.ASC);
        request.source(query);
        SearchResponse search = client.search(request,RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println("命中条数："+hits.getTotalHits());
        System.out.println("耗费时间：" + search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        client.close();
    }

    /**
     * 分页查询
     * @throws IOException
     */
    public static void pageQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        query.from(0);
        query.size(2);
        request.source(query);
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
     * 指定字段、剔除字段查询
     */
    public static void pointQuery() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        SearchRequest request = new SearchRequest().indices("user_demo");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] includes = {"name"};
        String[] excludes = {};
        query.fetchSource(includes, excludes);
        request.source(query);
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
