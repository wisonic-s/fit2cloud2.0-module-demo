package com.fit2cloud.cache.job;

import com.fit2cloud.quartz.anno.QuartzScheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncDemo {
    public void syncCloudServer() {
        System.out.println("this is demo");
    }
}
