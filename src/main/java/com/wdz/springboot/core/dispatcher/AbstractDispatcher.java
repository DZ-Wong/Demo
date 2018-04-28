package com.wdz.springboot.core.dispatcher;

import com.wdz.springboot.core.request.GenericRequest;
import com.wdz.springboot.core.response.GenericResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vip on 2018/4/24.
 */
public abstract class AbstractDispatcher<T> implements Dispatcher<T> {

    protected List<T> handlers = new ArrayList<>();

    @Override
    public void init() {
    }

    @Override
    public abstract GenericResponse handle(
        GenericRequest request) throws Exception;

    @Override
    public void setHandler(List<T> handlers) {
        this.handlers = handlers;
    }
}
