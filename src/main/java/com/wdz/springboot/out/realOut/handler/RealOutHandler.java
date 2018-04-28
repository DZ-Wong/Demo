package com.wdz.springboot.out.realOut.handler;

import com.wdz.springboot.Incoming.request.RealRequest;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import com.wdz.springboot.out.handler.ChannelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 对外接口可扩展的一个实例。
 */
@Component
public class RealOutHandler extends ChannelHandler<RealRequest, GenericResponse> {
    private static final Logger logger = LoggerFactory.getLogger(RealOutHandler.class);
    @Override
    public GenericResponse handle(RealRequest request) throws Exception {
        logger.debug("realOutHandler");
        /*对外接口业务逻辑的实现*/
        //doSomething
        GenericResponse response = new GenericResponse();
        return response;
    }

    @Override
    public boolean isSupport(GenericRequest request) {
        return true;
    }
}
