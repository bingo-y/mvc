package com.bingo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Pointcut("execution(* com.bingo.controller.*.user(..))")
    private void aopMethod(){};

    @Pointcut("execution(* com.bingo.controller.*.list(..))")
    private void listMethod(){};

    @Before("aopMethod()")
    public void logBefore() {
        LOG.info("before aspect执行");
    }

    @After("aopMethod()")
    public void logAfter() {
        LOG.info("after aspect执行");
    }

    @AfterReturning("aopMethod()")
    public void logAfterReturning() {
        LOG.info("after return aspect执行");
    }

    @Around("aopMethod()")
    public Object logAround(ProceedingJoinPoint pjp) {
        Object returnValue = null;
        try {
            LOG.info("around before aspect执行");
            returnValue = pjp.proceed();
            LOG.info("around after aspect执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        LOG.info("around return value : " + returnValue);
        return returnValue;
    }

    @AfterThrowing(pointcut = "listMethod()", throwing = "exc")
    public void logAfterThrowing(RuntimeException exc) {
        LOG.info("runtime exception : " + exc.toString());
    }

}
