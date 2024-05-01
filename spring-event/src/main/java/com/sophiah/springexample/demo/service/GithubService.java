package com.sophiah.springexample.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sophiah.springexample.demo.dataObject.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GithubService {
   private final RestTemplate restTemplate; 

   @Autowired
    public GithubService(
        @Qualifier("basicRestTemplate") RestTemplateBuilder restTemplateBuilder
        ) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public User findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        return results;
    }

}
