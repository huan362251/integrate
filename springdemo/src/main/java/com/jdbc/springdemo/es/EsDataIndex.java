package com.jdbc.springdemo.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class EsDataIndex {

    public static void main(String[] args) throws IOException {
        deleteData();
    }

    public static void insertData() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.108", 9200, "http"))
        );

        IndexRequest request = new IndexRequest();
        request.index("user_demo").id("1001");
        User user = new User();
        user.setAge(30);
        user.setName("hehe");
        user.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(user);
        request.source(value, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        client.close();
    }

    /*
    局部更新
     */
    public static void partUpdate() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        UpdateRequest request = new UpdateRequest();
        request.index("user_demo").id("1001");
        request.doc(XContentType.JSON,"sex","女");
        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        System.out.println(update.getResult());

        client.close();
    }

    /*
    查询数据
     */
    public static void getData() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );
        GetRequest getRequest = new GetRequest();
        getRequest.index("user_demo").id("1001");
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        client.close();
    }

    public static void deleteData() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http"))
        );

        DeleteRequest request = new DeleteRequest();
        request.index("user_demo").id("1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        client.close();
    }
}
