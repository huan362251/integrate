package com.jdbc.springdemo.web;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping("risk")
public class RiskRulerController {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @GetMapping("test")
    public void test() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> oneThread = CompletableFuture.supplyAsync(() -> {
            log.info("第一个异步");
            return "123";
        }, threadPoolExecutor);
        CompletableFuture<String> twoThread = CompletableFuture.supplyAsync(() -> {
            log.info("第二个异步");
            return "234";
        }, threadPoolExecutor);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(oneThread, twoThread);
        voidCompletableFuture.get(2, TimeUnit.SECONDS);
        createDemo(123L);
    }

    public void createDemo(Long merchantNo) throws InterruptedException, ExecutionException, TimeoutException {
        List<CompletableFuture> list = new ArrayList<>();
        List<Integer> rules = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            rules.add(i);
        }
        for (Integer rule : rules) {
            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                if(rule < 15){
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                log.info("线程处理中：" + rule);
                return rule;
            },threadPoolExecutor);
            list.add(integerCompletableFuture);
        }
        CompletableFuture[] completableFutures = list.toArray(new CompletableFuture[list.size() - 1]);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf();
        log.info("开始等待：{}" , System.currentTimeMillis());
        Void aVoid = voidCompletableFuture.get(2, TimeUnit.SECONDS);
        for (CompletableFuture completableFuture : completableFutures) {
            Integer integer = (Integer) completableFuture.get();
            log.info("获取每个线程结果：{}",integer);
        }
        log.info("结束等待：{}" , System.currentTimeMillis());
        log.info("perfect");
    }

}
