package com.bawangbai.boot.rabbitmq.config;

import com.rabbitmq.client.BuiltinExchangeType;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRabbit
public class MQConfig {

    public static final String EXCHANGE_Y = "Y";

    public static final String EXCHANGE_X = "X";

    public static final String EXCHANGE_NAME = "delayed.change";

    public static final String CONFIRM_NAME = "confirm.name";

    public static final String EXCHANGE_BACKUP = "exchange.backup";

    public static final String QUEUE_A = "QA";

    public static final String QUEUE_B = "QB";

    public static final String QUEUE_D = "QD";

    public static final String DELAYED_QUEUE = "delayed.queue";

    public static final String CONFIRM_QUEUE = "confirm.queue";

    public static final String QUEUE_BACKUP = "queue.backup";

    public static final String WARNING_BACKUP = "warning.backup";

//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        // 服务启动时候开启自动启动
//        rabbitAdmin.setAutoStartup(true);
//        return rabbitAdmin;
//    }


    @Bean
    public DirectExchange xExchange(){
        return new DirectExchange(EXCHANGE_X,true,false);
    }

    @Bean
    public DirectExchange yExchange(){
        return new DirectExchange(EXCHANGE_Y,true,false);
    }

    @Bean
    public DirectExchange confirmExchange(){
        return ExchangeBuilder.directExchange(CONFIRM_NAME).withArgument("alternate-exchange",EXCHANGE_BACKUP).durable(true).build();
    }


    @Bean
    public CustomExchange delayedExchange(){
        /**
         * String name, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments
         */
        Map<String, Object> arguments = new HashMap<>();
//        arguments.put("x-delayed-type",BuiltinExchangeType.DIRECT);
        arguments.put("x-delayed-type",BuiltinExchangeType.DIRECT.getType());
        CustomExchange customExchange = new CustomExchange(EXCHANGE_NAME,"x-delayed-message",true,false,arguments);
        return customExchange;
    }

    //这个交换机要向所有队列发消息，所有使用广播模式比较好
    @Bean
    public FanoutExchange backupExchange(){
        return new FanoutExchange(EXCHANGE_BACKUP,true,false);
    }

    @Bean
    public Queue queueA(){
        return QueueBuilder.durable(QUEUE_A).ttl(10000).deadLetterExchange(EXCHANGE_Y).deadLetterRoutingKey("YD").build();
    }
    @Bean
    public DirectExchange test_change(){
        return new DirectExchange("test_change",true,false);
    }
    @Bean
    public Queue test_one(){
        return QueueBuilder.durable("test_one").build();
    }

    @Bean
    public Binding testBind(@Qualifier("test_change") DirectExchange xExchange,@Qualifier("test_one") Queue queueA){
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }


    @Bean
    public Queue queueB(){
        return QueueBuilder.durable(QUEUE_B).ttl(20000).deadLetterExchange(EXCHANGE_Y).deadLetterRoutingKey("YD").build();
    }

    @Bean
    public Queue queueD(){
        return QueueBuilder.durable(QUEUE_D).build();
    }

    @Bean
    public Queue confirmQueue(){
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    @Bean
    public Queue backupQueue(){
        return QueueBuilder.durable(QUEUE_BACKUP).build();
    }

    @Bean
    public Queue warningQueue(){
        return QueueBuilder.durable(WARNING_BACKUP).build();
    }

    @Bean
    public Queue delayedQueue(){
        return QueueBuilder.durable(DELAYED_QUEUE).build();
    }

    @Bean
    public Binding exchangxBindQueueA(@Qualifier("xExchange") DirectExchange xExchange,@Qualifier("queueA") Queue queueA){
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }

    @Bean
    public Binding exchangxBindQueueB(@Qualifier("xExchange") DirectExchange xExchange,@Qualifier("queueB") Queue queueB){
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    @Bean
    public Binding exchangyBindQueueD(@Qualifier("yExchange") DirectExchange yExchange,@Qualifier("queueD") Queue queueD){
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }

    @Bean
    public Binding delayedBindDelayedQueue(@Qualifier("delayedExchange") CustomExchange delayedExchange ,
                                           @Qualifier("delayedQueue") Queue delayedQueue ){
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with("delayed.routingkey").noargs();
    }

    @Bean
    public Binding confirmBingConfirmQueue(@Qualifier("confirmExchange") DirectExchange confirmExchange,@Qualifier("confirmQueue") Queue confirmQueue){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with("key1");
    }

    @Bean
    public Binding backupBindBackupQueue(@Qualifier("backupExchange") FanoutExchange backupExchange,
                                         @Qualifier("backupQueue") Queue backupQueue){
        return BindingBuilder.bind(backupQueue).to(backupExchange);
    }

    @Bean
    public Binding warningBindBackupQueue(@Qualifier("backupExchange") FanoutExchange backupExchange,
                                         @Qualifier("warningQueue") Queue warningQueue){
        return BindingBuilder.bind(warningQueue).to(backupExchange);
    }


}
