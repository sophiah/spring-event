package com.sophiah.springexample.demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericBeans {

    @Bean("basicRestTemplate")
    public RestTemplateBuilder restTemplateBuilder() {
        RestTemplateBuilder restTemplateBuilder =  new RestTemplateBuilder();
        // add custom interceptor here.
        return restTemplateBuilder;
    } 
}
