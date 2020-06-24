package com.yak.hume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisDelayedQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDelayedQueueApplication.class, args);
    }

}
