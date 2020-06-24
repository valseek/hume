package com.yak.hume.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = HumeProperties.HUME_PREFIX)
@Getter
@Setter
public class HumeProperties {
    public static final String HUME_PREFIX = "hume";

    private String keyPrefix;

    @NestedConfigurationProperty
    RedisProperties redis;

}
