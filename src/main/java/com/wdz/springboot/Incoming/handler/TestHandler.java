package com.wdz.springboot.Incoming.handler;

import com.wdz.springboot.core.handler.AbstractHandler;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.stereotype.Component;

/**
 * Created by vip on 2018/4/24.
 */
@Component
public class TestHandler<R, S> extends AbstractHandler<GenericRequest, GenericResponse> {


    @Override
    public boolean isSupport(GenericRequest request) {
        return true;
    }
}
