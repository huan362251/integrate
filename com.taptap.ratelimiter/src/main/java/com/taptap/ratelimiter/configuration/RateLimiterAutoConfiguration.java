package com.taptap.ratelimiter.configuration;

import com.taptap.ratelimiter.core.RateLimitAspectHandler;
import com.taptap.ratelimiter.core.RateLimiterService;
import com.taptap.ratelimiter.core.RuleProvider;
import com.taptap.ratelimiter.web.RateLimitExceptionHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kl (http://kailing.pub)
 * @since 2021/3/16
 */
@Configuration
@ConditionalOnProperty(prefix = RateLimiterProperties.PREFIX, name = "enabled", havingValue = "true")
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RateLimiterProperties.class)
@Import({RateLimitAspectHandler.class, RateLimitExceptionHandler.class})
public class RateLimiterAutoConfiguration {
    private final RateLimiterProperties limiterProperties;
    public final static String REDISSON_BEAN_NAME = "rateLimiterRedissonBeanName";

    public RateLimiterAutoConfiguration(RateLimiterProperties limiterProperties) {
        this.limiterProperties = limiterProperties;
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        if (limiterProperties.getRedisClusterServer() != null) {
            config.useClusterServers().setPassword(limiterProperties.getRedisPassword())
                    .addNodeAddress(limiterProperties.getRedisClusterServer().getNodeAddresses());
        } else if (limiterProperties.getSentinelServer() != null) {
            config.useSentinelServers()
                    .setPassword(limiterProperties.getRedisPassword()).setMasterName("local-master")
                    .setCheckSentinelsList(false);
        } else {
            config.useSingleServer().setAddress(limiterProperties.getRedisAddress())
                    .setDatabase(limiterProperties.getRedisDatabase())
                    .setPassword(limiterProperties.getRedisPassword());
        }
        config.setEventLoopGroup(new NioEventLoopGroup());
        System.out.println("开始注册two");
        return Redisson.create(config);
    }

    @Bean
    public RuleProvider bizKeyProvider() {
        return new RuleProvider();
    }

    @Bean
    public RateLimiterService rateLimiterInfoProvider() {
        return new RateLimiterService(redissonClient());
    }


}
