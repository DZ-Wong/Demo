package com.wdz.springboot.Incoming.handler;

import com.wdz.springboot.core.handler.AbstractHandler;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.stereotype.Component;

@Component
public class Test2Handler<R, S>  extends AbstractHandler<GenericRequest, GenericResponse>{
    @Override
    public GenericResponse handle(GenericRequest request) {
        return null;
    }

    @Override
    public boolean isSupport(GenericRequest request) {
        return false;
    }
}
