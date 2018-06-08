package com.wdz.springboot.out.realOut.configuration2;


import com.wdz.springboot.out.realOut.async.RealManager;
import com.wdz.springboot.out.realOut.async.RealTask;
import com.wdz.springboot.out.realOut.async2.RealManager2;
import com.wdz.springboot.out.realOut.async2.RealTask2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RealConfiguration2 {

    @Bean
    public RealManager2 realManager2 (RealTask2 task) {
        return new RealManager2(task);
    }

    @Bean
    public RealTask2 realTask2() {
        return new RealTask2();
    }
}
