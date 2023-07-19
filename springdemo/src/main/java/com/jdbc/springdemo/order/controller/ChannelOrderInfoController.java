package com.jdbc.springdemo.order.controller;

import com.jdbc.springdemo.order.entity.ChannelTradeOrder;
import com.jdbc.springdemo.order.service.ChannelOrderInfoService;
import com.microsoft.azure.storage.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/channel")
public class ChannelOrderInfoController {

    @Autowired
    private ChannelOrderInfoService channelOrderInfoService;

    @GetMapping("dealAndSaveData")
    public void dealAndSaveData(){
        ChannelTradeOrder channelTradeOrder = new ChannelTradeOrder();
        channelOrderInfoService.dealAndSaveData(channelTradeOrder);
    }

    @GetMapping("generateFile/{batchNo}")
    public void genFile(@PathVariable("batchNo") String batchNo) throws Exception {
        log.info("start gen");
        channelOrderInfoService.batchNoAndGenerate(batchNo);
        log.info("end gen");
    }

}
