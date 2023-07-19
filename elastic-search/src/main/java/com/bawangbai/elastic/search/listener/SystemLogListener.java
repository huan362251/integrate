package com.bawangbai.elastic.search.listener;

import cn.hutool.core.thread.ThreadUtil;
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.CreateRequest;
import com.bawangbai.elastic.search.pojo.es.SystemLogDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class SystemLogListener {

//    @Autowired
//    private ElasticsearchClient client;

    @RabbitListener(queues = "system.log")
    public void listenerQA(SystemLogDO systemLogDO) throws IOException {
//        CreateRequest request = new CreateRequest.Builder<SystemLogDO>()
//                .id(String.valueOf(systemLogDO.getId()))
//                .index("system_log")
//                .document(systemLogDO)
//                .build();
//        client.create(request);
//        log.info("收到队列信息{},{}", systemLogDO);
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "demo.listener"))
    public void test(String msg) throws Exception {
        for (int i = 0; i < 10; i++) {
            log.info("test demo:{},msg:{}",i,msg);
            ThreadUtil.sleep(1, TimeUnit.SECONDS);
        }

        log.info("10s后");
        ThreadUtil.sleep(7,TimeUnit.SECONDS);
        log.info("睡眠7s后");
        for (int i = 0; i < 10; i++) {
            if (i==3) {
                throw new Exception("error");
            }
            log.info("repeat test demo:{},msg:{}",i,msg);
            ThreadUtil.sleep(1, TimeUnit.SECONDS);
        }
    }

}
