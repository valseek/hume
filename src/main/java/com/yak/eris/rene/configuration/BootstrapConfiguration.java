package com.yak.eris.rene.configuration;

import io.lettuce.core.resource.ClientResources;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

@EnableConfigurationProperties({HumeProperties.class})
@Configuration
public class BootstrapConfiguration {

    private final HumeProperties humeProperties;

    BootstrapConfiguration(HumeProperties humeProperties) {
        this.humeProperties = humeProperties;
    }

    RedisConnectionFactory getHumeRedisConnectionFactory(ObjectProvider<LettuceClientConfigurationBuilderCustomizer> builderCustomizers,
                                                         ClientResources clientResources) {
        // hack lettuce connection configuration
        try {
            Class<?> clz = Class.forName("org.springframework.boot.autoconfigure.data.redis.LettuceConnectionConfiguration");
            Object configuration = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                @SneakyThrows
                @Override
                public Object run() {
                    Constructor c = clz.getDeclaredConstructor(RedisProperties.class, ObjectProvider.class, ObjectProvider.class);
                    c.setAccessible(true);
                    return c.newInstance(humeProperties.getRedis(), new HumeObjectProvider(), new HumeObjectProvider());
                }
            });

            Method m = clz.getDeclaredMethod("redisConnectionFactory");
            m.setAccessible(true);
            return (RedisConnectionFactory) m.invoke(configuration, builderCustomizers , clientResources);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }



    private static class HumeObjectProvider implements ObjectProvider {

        @Override
        public Object getObject(Object... args) throws BeansException {
            return null;
        }

        @Override
        public Object getIfAvailable() throws BeansException {
            return null;
        }

        @Override
        public Object getIfUnique() throws BeansException {
            return null;
        }

        @Override
        public Object getObject() throws BeansException {
            return null;
        }
    }

}
