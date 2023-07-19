package com.bawangbai.boot.rabbitmq.controller;

import com.bawangbai.boot.rabbitmq.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.postprocessor.MessagePostProcessorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("sendMsg")
    public void sendGeneralMsg(){
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("pacypay.stl.task","haha" + i);
        }
    }

    @GetMapping("test")
    public void sendTestMsg(){
        log.info("begin");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Student student = new Student();
            student.setId(i);
            student.setDetail(UUID.randomUUID().toString());
        }
        for (int i = 0; i < 81000000; i++) {
            rabbitTemplate.convertAndSend("test",students);
        }
        log.info("end");
    }

    @GetMapping("sendmsg/{msg}")
    public void sendMsg(@PathVariable("msg") String msg) {
        log.info(" 当前时间：{}, 发送一条信息给两个 TTL  队列:{}", LocalDateTime.now().toString(), msg);
        rabbitTemplate.convertAndSend("X", "XA", msg + " | 哈哈10S");
        rabbitTemplate.convertAndSend("X", "XB", msg + " | 哈哈20S");
    }

    @GetMapping("sendmsgttl/{msg}")
    public void sendDelayed(@PathVariable("msg") String msg) {
        log.info("send msg:{},time:{}", msg, LocalDateTime.now().toString());
        for (int i = 0; i < 10; i++) {

            rabbitTemplate.convertAndSend("delayed.change", "delayed.routingkey", msg + " : 5秒的消息，你收的到吗", message -> {
                message.getMessageProperties().setDelay(5000);
                return message;
            });

            rabbitTemplate.convertAndSend("delayed.change", "delayed.routingkey", msg + " : 20秒的消息，你收的到吗", message -> {
                message.getMessageProperties().setDelay(20000);
                return message;
            });
        }
    }

    @GetMapping("sendMsg/confirm/{msg}")
    public void sendMsgConfirm(@PathVariable("msg") String msg) {
        log.info("send msg:{},time:{}", msg, LocalDateTime.now().toString());
        /**
         * confirm.name
         * confirm.queue
         * key1
         */
        //发送正常能被接收 到的消息
        rabbitTemplate.convertAndSend("confirm.name","key1","发送正常能被接收到的消息",new CorrelationData(UUID.randomUUID().toString()));

        //发送交换机不能接收到的消息
        rabbitTemplate.convertAndSend("confirm.name"+3,"key1","交换机异常消息",new CorrelationData(UUID.randomUUID().toString()));

        //发送队列异常不能接收到的消息
        rabbitTemplate.convertAndSend("confirm.name","key2","队列找不到异常消息",new CorrelationData(UUID.randomUUID().toString()));

    }

    @GetMapping("sendMsg/backup/{msg}")
    public void sendMsgBackup(@PathVariable("msg") String msg) {
        log.info("send msg:{},time:{}", msg, LocalDateTime.now().toString());
        /**
         * confirm.name
         * confirm.queue
         * key1
         */
        //发送正常能被接收 到的消息
        rabbitTemplate.convertAndSend("confirm.name","key1","发送正常能被接收到的消息",new CorrelationData(UUID.randomUUID().toString()));

        //发送交换机不能接收到的消息
        rabbitTemplate.convertAndSend("confirm.name"+3,"key1","交换机异常消息",new CorrelationData(UUID.randomUUID().toString()));

        //发送队列异常不能接收到的消息
        rabbitTemplate.convertAndSend("confirm.name","key999","队列找不到异常消息",new CorrelationData(UUID.randomUUID().toString()));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
