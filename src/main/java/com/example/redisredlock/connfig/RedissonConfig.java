package com.example.redisredlock.connfig;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置类
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
       Config config = new Config();
       config.useClusterServers()
               .setScanInterval(2000)
               .addNodeAddress("redis://127.0.0.1:7001","redis://127.0.0.1:7002")
               .addNodeAddress("redis://127.0.0.1:7003");
       RedissonClient redisson = Redisson.create(config);
       return redisson;
    }

}
