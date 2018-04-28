package com.wdz.springboot.Incoming.handler;

import com.wdz.springboot.Incoming.request.RealRequest;
import com.wdz.springboot.core.handler.AbstractHandler;
import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;
import org.springframework.stereotype.Component;

/**
 * 实际业务入口处理器。
 * 一定要用真实的请求类替换掉泛型。这里因为没有定义实际的返回类，所以暂时用通用返回类。
 * Created by vip on 2018/4/24.
 */
@Component
public class RealInHandler extends AbstractHandler<RealRequest, GenericResponse> {


    @Override
    public boolean isSupport(GenericRequest request) {
        return true;
    }
}
