package com.jdbc.springdemo.order.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RabbitListener(queues = "trade.order.batch")
@Service
public class OrderInfoDealListener {

//    @Autowired
//    private
//
//    @RabbitHandler
//    public void listener(String batchNo) {
//        System.out.println("收到过期的订单信息 ：准备关闭订单 " + batchNo);
//        try{
//            service.closeOrder(orderEntity);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        }catch (Exception e){
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
//        }
//
//    }

}
