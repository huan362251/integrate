package com.bawangbai.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;

@Slf4j
@Data
@Configuration
@ConditionalOnProperty(prefix = "reidsson",name = "enable",havingValue = "true")
public class RedissonConfig {

    @Value("${reidsson.masterName:}")
    private String masterName;

    @Value("${reidsson.singleAddress:}")
    private String singleAddress;

//    @Value("${reidsson.sentinelAddresses}")
    @Value("#{'${reidsson.sentinelAddresses:}'.split(',')}")
    private String[] sentinelAddresses;

    @Value("${reidsson.database:}")
    private Integer database;

    @Value("${reidsson.password:}")
    private String password;

    @Bean
    @Profile("prod")
    public RedissonClient redissonClientProd() {
        Config config = new Config();
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        sentinelServersConfig.setMasterName(masterName);
        sentinelServersConfig.setDatabase(database);
        sentinelServersConfig.setPassword(password);
        for (String sentinelAddress : sentinelAddresses) {
            sentinelServersConfig.addSentinelAddress(sentinelAddress);
        }
        return Redisson.create(config);
    }

    @Bean
    @Profile({"dev","test","sandbox"})
    public RedissonClient redissonClientDev() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setDatabase(database);
        singleServerConfig.setAddress(singleAddress);
        singleServerConfig.setPassword(password);
        return Redisson.create(config);
    }
}
