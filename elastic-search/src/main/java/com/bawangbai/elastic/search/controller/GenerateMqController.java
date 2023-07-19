package com.bawangbai.elastic.search.controller;

//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.CreateRequest;
//import co.elastic.clients.elasticsearch.core.CreateResponse;
//import co.elastic.clients.elasticsearch.core.SearchRequest;
//import co.elastic.clients.elasticsearch.core.SearchResponse;
//import co.elastic.clients.elasticsearch.core.search.Hit;
//import co.elastic.clients.elasticsearch.sql.QueryRequest;
import com.bawangbai.elastic.search.pojo.es.SystemLogDO;
import com.bawangbai.elastic.search.util.SnowflakeConfig;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("generate")
public class GenerateMqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private SnowflakeConfig snowflakeConfig;

//    @Autowired
//    private ElasticsearchClient client;

    @GetMapping("genLog")
    public void genLog() throws IOException {
//        Random random = new Random();
//
//        SystemLogDO systemLogDO = new SystemLogDO();
//        systemLogDO.setId(snowflakeConfig.snowflakeId());
//        systemLogDO.setGenerateTime(LocalDateTime.now());
////        systemLogDO.setGenerateTimeOne(LocalDateTime.now());
//        systemLogDO.setMerchantNo(Long.valueOf(random.nextInt(10000)));
//        systemLogDO.setDetails("hehe");
//        String s = UUID.randomUUID().toString();
//        systemLogDO.setMerchantOrderNumber(s);
//        systemLogDO.setOriTxnId(snowflakeConfig.snowflakeId());
//        systemLogDO.setThreadId(s + ":" + Thread.currentThread().getName());
//        systemLogDO.setTxnId(snowflakeConfig.snowflakeId());
////        rabbitTemplate.convertAndSend("system.log",systemLogDO);
//        log.info("gen log success");
//
//
//        CreateRequest request = new CreateRequest.Builder<SystemLogDO>()
//                .index("system_log_3")
//                .id(String.valueOf(systemLogDO.getId()))
//                .document(systemLogDO)
//                .build();
//
//        CreateResponse createResponse = client.create(request);
//
////        client.search(q->q.aggregations(),SystemLogDO.class);
//
//        System.out.println(createResponse);
    }

    @GetMapping("queryMonthCount")
    public void queryMonthCount() throws IOException {
//        SearchResponse<SystemLogDO> search = client.search(builder -> builder.index("system_log").query(
//                        query -> query.match(matchQuery -> matchQuery.field("merchantNo").query("9938"))
//                )
//                , SystemLogDO.class);
//        log.info("查询总条数：{}",search.hits().total());
//        List<Hit<SystemLogDO>> hits = search.hits().hits();
//        for (Hit<SystemLogDO> hit : hits) {
//            SystemLogDO source = hit.source();
//            log.info("查询信息：{}",source);
//        }
    }

}
