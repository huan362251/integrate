package com.bawangbai.boot_redisson.util;

//import lombok.Data;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SentinelServersConfig;
//import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Data
@Configuration
@ConfigurationProperties(prefix = "reidsson")
public class RedissonConfig {

//    private String masterName;
//
//    private String singleAddress;
//
//    private String[] sentinelAddresses;
//
//    private int database;
//
//    private String password;
//
//    @Bean
//    @Profile(value = "prod")
//    public RedissonClient redissonClientProd() {
//
//        Config config = new Config();
//        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
//        sentinelServersConfig.setMasterName(masterName);
//        sentinelServersConfig.setDatabase(database);
//        sentinelServersConfig.setPassword(password);
//        for (String sentinelAddress : sentinelAddresses) {
//            sentinelServersConfig.addSentinelAddress(sentinelAddress);
//        }
//        return Redisson.create(config);
//    }
//
//    @Bean
//    @Profile(value = "dev")
//    public RedissonClient redissonClientDev() {
//        Config config = new Config();
//        SingleServerConfig singleServerConfig = config.useSingleServer();
//        singleServerConfig.setDatabase(database);
//        singleServerConfig.setAddress(singleAddress);
//        singleServerConfig.setPassword(password);
//        return Redisson.create(config);
//    }
}
