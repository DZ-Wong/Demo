package com.wdz.springboot.out.dispatcher;

import com.wdz.springboot.out.handler.ChannelHandler;
import com.wdz.springboot.core.dispatcher.AbstractDispatcher;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChannelDispatcher extends AbstractDispatcher<ChannelHandler> {
    private static final Logger logger = LoggerFactory.getLogger(ChannelDispatcher.class);
    @Override
    public GenericResponse handle(GenericRequest request) throws Exception{
        for (ChannelHandler<GenericRequest, GenericResponse> handler : handlers) {
            if (handler.isSupport(request)) {
                logger.debug("channel true");
                return handler.handle(request);
            }
        }
        return null;
    }
}
