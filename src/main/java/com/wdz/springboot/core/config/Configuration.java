package com.wdz.springboot.core.config;

import com.wdz.springboot.Incoming.dispatcher.IncomingDispatcher;
import com.wdz.springboot.core.handler.AbstractHandler;
import org.springframework.context.annotation.Bean;

import java.util.List;


/**
 * Created by vip on 2018/4/24.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public IncomingDispatcher getDispatcher(List<AbstractHandler> handlers) {
        IncomingDispatcher  dispatcher = new IncomingDispatcher();
        dispatcher.setHandler(handlers);
        return dispatcher;
    }
}
