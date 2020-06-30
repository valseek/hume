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

    private HumeRedisConnectionFactory getLettuceRedisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        RedisProperties redisProperties = humeProperties.getRedis();
        configuration.setPassword(redisProperties.getPassword());
        configuration.setPort(redisProperties.getPort());
        configuration.setHostName(redisProperties.getHost());
        configuration.setDatabase(redisProperties.getDatabase());
        Pool pool = redisProperties.getLettuce().getPool();
        LettuceClientConfigurationBuilder builder = pool == null ?
                LettuceClientConfiguration.builder() :
                LettucePoolingClientConfiguration.builder().poolConfig(getPoolConfig(pool));
        HumeRedisConnectionFactory factory = new HumeRedisConnectionFactory(configuration);
        factory.getConnection();
        return factory;
    }

    private GenericObjectPoolConfig<?> getPoolConfig(Pool properties){
        GenericObjectPoolConfig<?> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(properties.getMaxActive());
        config.setMaxIdle(properties.getMaxIdle());
        config.setMinIdle(properties.getMinIdle());
        if (properties.getTimeBetweenEvictionRuns() != null) {
            config.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRuns().toMillis());
        }
        if (properties.getMaxWait() != null) {
            config.setMaxWaitMillis(properties.getMaxWait().toMillis());
        }
        return config;
    }


















}
