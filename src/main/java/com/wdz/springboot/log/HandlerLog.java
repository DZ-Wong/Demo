package com.wdz.springboot.log;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HandlerLog {

    private static final Logger logger = LoggerFactory.getLogger(HandlerLog.class);

    @Pointcut("execution(public * com.wdz.springboot.Incoming.handler.*.*(..))")
    public void weblog() {}

    @Before("weblog()")
    public void printTime() {
        logger.info("HandlerLog CurrentTime: " + System.currentTimeMillis());

    }

    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("返回值 ：" + ret);
    }
}
