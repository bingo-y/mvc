package com.bingo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by tuyx on 2017/1/16.
 */
@Component
@Aspect
public class LogAspect {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.bingo.controller.*.*(..))")
    private void aopMethod(){};

    @Before("aopMethod()")
    public void logPrintf() {
        LOG.info(LogAspect.class.getName(), "aspect执行");
    }
}
