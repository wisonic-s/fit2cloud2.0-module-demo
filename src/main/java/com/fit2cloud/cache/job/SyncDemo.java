package com.fit2cloud.cache.job;

import com.fit2cloud.quartz.anno.QuartzScheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncDemo {
    @QuartzScheduled(cron = "${cron.expression.demo}")
    public void syncCloudServer() {
        System.out.println("this is demo");
    }
}
