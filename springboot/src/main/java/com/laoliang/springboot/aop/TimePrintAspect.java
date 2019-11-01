package com.laoliang.springboot.aop;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Aspect
@Order(value = 2)
public class TimePrintAspect {

    @Pointcut(value = "(execution(* *.*(..)) && @annotation(com.laoliang.springboot.aop.TimePrint))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void lockBefore() throws Throwable {
        log.info("当前时间：" + DateUtil.formatDateTime(new Date()));
    }


}