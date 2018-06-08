package com.wdz.springboot.out.realOut.handler;

import com.wdz.springboot.Incoming.request.RealRequest;
import com.wdz.springboot.core.async.Event;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import com.wdz.springboot.out.handler.ChannelHandler;
import com.wdz.springboot.out.realOut.async.RealData;
import com.wdz.springboot.out.realOut.async.RealManager;
import com.wdz.springboot.out.realOut.async2.RealData2;
import com.wdz.springboot.out.realOut.async2.RealManager2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 对外接口可扩展的一个实例。
 */
@Component
public class RealOutHandler extends ChannelHandler<RealRequest, GenericResponse> {
    private static final Logger logger = LoggerFactory.getLogger(RealOutHandler.class);
    @Autowired
    private RealManager realManager;
    @Autowired
    private RealManager2 realManager2;
    @Override
    public GenericResponse handle(RealRequest request) throws Exception {
        logger.debug("realOutHandler");
        /*对外接口业务逻辑的实现*/
        //doSomething
        GenericResponse response = new GenericResponse();
        RealData realData = new RealData();

        realManager.put(new Event<RealData>(realData));

        RealData2 realData2 = new RealData2();

        realManager2.put(new Event<RealData2>(realData2));

        return response;
    }

    @Override
    public boolean isSupport(GenericRequest request) {
        return true;
    }
}
