package com.wdz.springboot.out.handler;

import com.wdz.springboot.core.handler.Handler;

//业务逻辑抽象层。
public abstract class ChannelHandler<R, S> implements Handler<R, S> {

    //如果有统一的业务逻辑，可以写在这里。

}
