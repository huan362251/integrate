package com.example.elastic.search.company.config;



import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.time.Duration;

@Configuration
public class ElasticSearchProperties {

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.200.30", 9200));

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


}
