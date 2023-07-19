package com.example.elastic.search8.config;


import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Arrays;

@Configuration
public class ElasticSearchProperties {

//    @Bean
//    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
//        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.56.10", 9200));
//
//        builder.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
//            //最大连接数
//            httpAsyncClientBuilder.setMaxConnTotal(60);
//            //每5分钟发生一次心跳保持连接
//            httpAsyncClientBuilder.setKeepAliveStrategy((response, context) -> Duration.ofMinutes(5).toMillis());
//
//            return httpAsyncClientBuilder;
//        });
//
//        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
//        return new ElasticsearchRestTemplate(restHighLevelClient);
//    }

//    @Resource
//    ObjectMapper objectMapper;

    //注入IOC容器
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        ElasticsearchTransport transport = getElasticsearchTransport();
        return new ElasticsearchClient(transport);
    }

    @Bean
    public ElasticsearchAsyncClient elasticsearchAsyncClient() {
        ElasticsearchTransport transport = getElasticsearchTransport();
        return new ElasticsearchAsyncClient(transport);
    }

    private ElasticsearchTransport getElasticsearchTransport() {
//        RestClient client = RestClient.builder(new HttpHost("192.168.56.101", 9200))
//                .setHttpClientConfigCallback(httpAsyncClientBuilder -> {
//                    httpAsyncClientBuilder.disableAuthCaching();
//                    httpAsyncClientBuilder.setMaxConnTotal(600);
//                    httpAsyncClientBuilder.setKeepAliveStrategy((response, context) -> Duration.ofMinutes(5).toMillis());
////                    httpAsyncClientBuilder.setMaxConnPerRoute(20);
//                    return httpAsyncClientBuilder;
//                }).build();

//        JacksonJsonpMapper jacksonJsonpMapper = new JacksonJsonpMapper(objectMapper);
//        ElasticsearchTransport transport = new RestClientTransport(client,  new JacksonJsonpMapper());
//        return transport;
        // Create the low-level client
        String nodes = "http://192.168.56.101:9200";
//        String nodes = "http://192.168.200.30:9200";
        HttpHost[] httpHosts = Arrays.stream(nodes.split(",")).map(x -> {
            String[] hostInfo = x.split(":");
            return new HttpHost("192.168.56.101", Integer.parseInt("9200"));
        }).toArray(HttpHost[]::new);

        RestClientBuilder restClient = RestClient.builder(httpHosts);

        restClient.setRequestConfigCallback(
                requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(30000)
                        .setSocketTimeout(600000)
        );

        restClient.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
            //最大连接数
            httpAsyncClientBuilder.setMaxConnTotal(5);
            //每5分钟发生一次心跳保持连接
            httpAsyncClientBuilder.setKeepAliveStrategy((response, context) -> Duration.ofMinutes(5).toMillis());
            //线程存活 避免socket断连
            httpAsyncClientBuilder.setDefaultIOReactorConfig(IOReactorConfig.custom().setSoKeepAlive(true).build());
            return httpAsyncClientBuilder;
        });


        RestClient build = restClient.build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                build, new JacksonJsonpMapper());

        // And create the API client
        return transport;
    }
}
