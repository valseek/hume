package com.yak.eris.rene.run;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestRedisConnection implements CommandLineRunner {

    @Autowired
    StringRedisTemplate template;

    @Override
    public void run(String... args) throws Exception {
        while (true){
            template.opsForValue().set("ttt","aaa");
            System.out.println(template.opsForValue().get("ttt"));
        }
    }
}
