package com.yak.eris.rene.annotation;


import org.springframework.messaging.handler.annotation.MessageMapping;

import java.lang.annotation.*;


@MessageMapping
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(HumeListeners.class)
public @interface HumeListener {

    /**
     * 队列名
     */
    String name() ;

    /**
     * 并发数
     */
    int concurrence() default 1;

}
