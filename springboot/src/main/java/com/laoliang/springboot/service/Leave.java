package com.laoliang.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author laoliangliang
 * @since 2019-11-06 21:44
 */
@Component
@Slf4j
public class Leave implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.error("异常退出 ===> destroy");
    }
}
