package com.bookAlias.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(initMethod = "myInitMethod")
    public Apple apple(){
        Apple apple = new Apple();
        apple.setName("����������������A");
        return apple;
    }
}