package com.jdbc.springdemo.order.job;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = "trade.order")
@Service
public class OrderFileListener {

//    @RabbitHandler
//    public void listener(String dfsa) throws IOException {
//        System.out.println("收到过期的订单信息 ：准备关闭订单 " + orderEntity.getOrderSn());
//        try{
//            service.closeOrder(orderEntity);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        }catch (Exception e){
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
//        }
//
//    }

}
