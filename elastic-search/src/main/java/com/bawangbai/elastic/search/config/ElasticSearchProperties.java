package com.bawangbai.elastic.search.config;


//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;
import java.time.Duration;

@Configuration
public class ElasticSearchProperties {

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.56.10", 9200));

        builder.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
            //最大连接数
            httpAsyncClientBuilder.setMaxConnTotal(60);
            //每5分钟发生一次心跳保持连接
            httpAsyncClientBuilder.setKeepAliveStrategy((response, context) -> Duration.ofMinutes(5).toMillis());

            return httpAsyncClientBuilder;
        });

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return new ElasticsearchRestTemplate(restHighLevelClient);
    }

//    @Resource
//    ObjectMapper objectMapper;
//
//    //注入IOC容器
//    @Bean
//    public ElasticsearchClient elasticsearchClient() {
//        RestClient client = RestClient.builder(new HttpHost("192.168.56.101", 9200, "http"))
//                .setHttpClientConfigCallback(httpAsyncClientBuilder -> {
//                    httpAsyncClientBuilder.disableAuthCaching();
//                    httpAsyncClientBuilder.setMaxConnTotal(60);
//                    httpAsyncClientBuilder.setKeepAliveStrategy((response, context) -> Duration.ofMinutes(5).toMillis());
////                    httpAsyncClientBuilder.setMaxConnPerRoute(20);
//                    return httpAsyncClientBuilder;
//                }).build();
//        JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper(objectMapper);
//        ElasticsearchTransport transport = new RestClientTransport(client, jacksonJsonpMapper);
//        return new ElasticsearchClient(transport);
//    }
}
