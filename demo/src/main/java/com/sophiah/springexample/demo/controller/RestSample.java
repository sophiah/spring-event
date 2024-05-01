package com.sophiah.springexample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sophiah.springexample.demo.dataObject.User;
import com.sophiah.springexample.demo.event.SampleEvent;
import com.sophiah.springexample.demo.event.SampleEvent.SampleEventHandler;
import com.sophiah.springexample.demo.service.GithubService;


@RestController
public class RestSample {

    private GithubService githubService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public RestSample(
        GithubService githubService,
        ApplicationEventPublisher applicationEventPublisher
    ) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.githubService = githubService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id) throws InterruptedException {
        SampleEvent sampleEvent = new SampleEvent(this, id);
        applicationEventPublisher.publishEvent(sampleEvent);
        return this.githubService.findUser(id);
    }
}
