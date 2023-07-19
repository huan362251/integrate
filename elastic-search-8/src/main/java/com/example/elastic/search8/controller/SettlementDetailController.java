package com.example.elastic.search8.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.elastic.search8.entity.SettlementDetailEsDO;
import com.example.elastic.search8.service.SettlementDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("detail")
public class SettlementDetailController {

    @Autowired
    private ElasticsearchClient client;

    @Autowired
    private SettlementDetailService settlementDetailService;

    @GetMapping("test")
    public void test() throws IOException {
        settlementDetailService.test();
    }

    @GetMapping("insertDetail")
    public void insertDetail(){
        settlementDetailService.insertDetail();
    }

    @GetMapping("queryTest")
    public void queryTest() throws IOException {
        settlementDetailService.queryTest();
    }

    @GetMapping("aliasTest")
    public void aliasTest() throws IOException {
        settlementDetailService.aliasTest();
    }

    @GetMapping("addSettle")
    public void addSettle(){
        settlementDetailService.addSettle();
    }

}
