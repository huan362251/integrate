package com.bawangbai.boot.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class RabbitProReturnConfirmConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnsCallback(this);
    }


    /**
     * 交换机响应报文，主要用来处理交换机无法找到时的问题
     *
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            log.info("消息发送交换机成功，msgId:{}", correlationData.getId());
        } else {
            log.info("消息发送交换机失败，msgId:{},reson:{}", correlationData.getId(), s);
        }
    }

    /**
     * 队列无法响应报文，当路由队列发生问题时报错
     *
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("消息发队列发生问题,exchange:{},routingKey:{},message:{},replyCode:{},replyMsg:{}",
                returnedMessage.getExchange(),
                returnedMessage.getMessage(),
                returnedMessage.getReplyCode(),
                returnedMessage.getReplyText(),
                returnedMessage.getRoutingKey());
    }

}
