package com.sophiah.springexample.demo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class SampleEvent  extends ApplicationEvent  {

    private final String userName;

    public SampleEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    @Component
    @Slf4j
    public static class SampleEventHandler {
        @EventListener
        @Async
        public void handleUserLoginEvent(SampleEvent event) throws InterruptedException {
            String username = event.getUserName();
            log.info("Event Start -- " + username);
            Thread.sleep(5000);
            log.info("Event End -- " + username);
        }
    }

}
