package com.wdz.springboot.core.handler;

import com.wdz.springboot.core.request.GenericRequest;

/**
 * Created by vip on 2018/4/24.
 */
public interface Handler<R, S> {

    S handle(GenericRequest request);

    boolean isSupport(GenericRequest request);

}
