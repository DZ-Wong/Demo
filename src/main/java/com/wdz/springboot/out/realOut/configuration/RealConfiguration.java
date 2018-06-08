package com.wdz.springboot.out.realOut.configuration;


import com.wdz.springboot.out.realOut.async.RealData;
import com.wdz.springboot.out.realOut.async.RealManager;
import com.wdz.springboot.out.realOut.async.RealTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RealConfiguration {

    @Bean
    public RealManager realManager (RealTask task) {
        RealManager realManager = new RealManager(task);
//        realManager.setTask(task);
//        realManager.init();
        return realManager;
    }

    @Bean
    public RealTask realTask() {
        RealTask realTask = new RealTask();
        return realTask;
    }
}
