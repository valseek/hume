package com.yak.hume.annotation;


import org.springframework.messaging.handler.annotation.MessageMapping;

import java.lang.annotation.*;









@MessageMapping
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HumeListener {

}
