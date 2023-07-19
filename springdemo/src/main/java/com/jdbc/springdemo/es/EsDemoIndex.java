package com.jdbc.springdemo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class EsDemoIndex {

    public static void main(String[] args) throws IOException {
        deleteIndexData();
    }

    /*
    创建索引
     */
    public static void createIndex() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.108", 9200, "http"))
        );

        CreateIndexRequest userDemo = new CreateIndexRequest("user_demo");
        CreateIndexResponse createIndexResponse = client.indices().create(userDemo, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引创建成功标记：" + acknowledged);

        client.close();
    }

    public static void queryIndexData() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );

        GetIndexRequest request = new GetIndexRequest("user_demo");
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());


        client.close();
    }

    public static void deleteIndexData() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.108", 9200, "http"))
        );

        DeleteIndexRequest deleteRequest = new DeleteIndexRequest("user_demo");
        AcknowledgedResponse response = client.indices().delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
        client.close();
    }

}
