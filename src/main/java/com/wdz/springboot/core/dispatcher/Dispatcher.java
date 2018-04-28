package com.wdz.springboot.core.dispatcher;

import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;

import java.util.List;

/**
 * Created by vip on 2018/4/24.
 */
public interface Dispatcher<T> {

    void init();

    GenericResponse handle(GenericRequest request) throws Exception;

    void setHandler(List<T> handlers);
}
