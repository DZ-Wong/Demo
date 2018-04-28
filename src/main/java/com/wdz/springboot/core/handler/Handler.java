package com.wdz.springboot.core.handler;

import com.wdz.springboot.core.request.GenericRequest;

/**
 * Created by vip on 2018/4/24.
 */
public interface Handler<R, S> {

    S handle(R request) throws Exception;

    boolean isSupport(GenericRequest request);

}
