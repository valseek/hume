package com.yak.hume.configuration;

import io.lettuce.core.RedisURI;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Pool;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration.LettuceClientConfigurationBuilder;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;

@EnableConfigurationProperties({HumeProperties.class })
@Configuration
public class BootstrapConfiguration {

    private HumeProperties humeProperties;

    BootstrapConfiguration(HumeProperties humeProperties ){
        this.humeProperties = humeProperties;
    }

    public static class HumeRedisConnectionFactory extends LettuceConnectionFactory {
        public HumeRedisConnectionFactory(RedisStandaloneConfiguration configuration) {
            super(configuration);
        }
    }

    public HumeRedisConnectionFactory getHumeRedisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        RedisProperties redisProperties = humeProperties.getRedis();
        configuration.setPassword(redisProperties.getPassword());
        configuration.setPort(redisProperties.getPort());
        configuration.setHostName(redisProperties.getHost());
        configuration.setDatabase(redisProperties.getDatabase());
        LettuceClientConfigurationBuilder builder = createBuilder(this.humeProperties.getRedis().getLettuce().getPool());
        HumeRedisConnectionFactory factory = new HumeRedisConnectionFactory(configuration);
        factory.getConnection();
        return factory;
    }

    private LettuceClientConfigurationBuilder createBuilder(Pool pool) {
        if (pool == null) {
            return LettuceClientConfiguration.builder();
        }
        GenericObjectPoolConfig<?> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(pool.getMaxActive());
        config.setMaxTotal(pool.getMaxIdle());
        config.setMinIdle(pool.getMinIdle());
        return LettucePoolingClientConfiguration.builder().poolConfig(config);
    }















}
