package com.wdz.springboot.Incoming.dispatcher;

import com.wdz.springboot.Incoming.handler.TestHandler;
import com.wdz.springboot.core.handler.AbstractHandler;
import com.wdz.springboot.core.dispatcher.AbstractDispatcher;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;

/**
 * Created by vip on 2018/4/24.
 */
public class IncomingDispatcher extends AbstractDispatcher<AbstractHandler> {


    @Override
    public GenericResponse handle(GenericRequest request) {
        for (AbstractHandler<GenericRequest, GenericResponse> handler : handlers) {
            if (handler.isSupport(request)) {
                return handler.handle(request);
            }
        }
        return null;
    }
}
