package com.wdz.springboot.config;

import com.wdz.springboot.Incoming.dispatcher.IncomingDispatcher;
import com.wdz.springboot.out.dispatcher.ChannelDispatcher;
import com.wdz.springboot.out.handler.ChannelHandler;
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

    @Bean
    public ChannelDispatcher getChannelDispatcher(List<ChannelHandler> handlers) {
        ChannelDispatcher dispatcher = new ChannelDispatcher();
        dispatcher.setHandler(handlers);
        return dispatcher;
    }
}
