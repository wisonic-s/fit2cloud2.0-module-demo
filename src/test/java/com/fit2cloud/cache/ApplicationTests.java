package com.fit2cloud.cache;

import com.fit2cloud.cache.job.SyncDemo;
import com.fit2cloud.cache.service.FlavorService;
import com.fit2cloud.commons.server.base.domain.CloudAccount;
import com.fit2cloud.commons.server.base.mapper.CloudAccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Resource
    private CloudAccountMapper cloudAccountMapper;

    @Resource
    private FlavorService flavorService;

    @Test
    public void contextLoads() {
        flavorService.syncFlavors();
    }

}
