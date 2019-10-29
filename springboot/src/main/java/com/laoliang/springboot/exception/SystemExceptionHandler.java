package com.laoliang.springboot.exception;

import com.laoliang.springboot.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author laoliangliang
 * @date 2019/10/29 17:22
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {



    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public ResultInfo CommonExceptionHandler(HttpServletRequest request, CommonException e) {
        log.error("defaultExceptionHandler ==> " + e.getMessage());
        e.printStackTrace();
        String exceptionName = ClassUtils.getShortName(e.getClass());
        log.error("ExceptionName ==> " + exceptionName);
        return new ResultInfo(false, 9998, e.getMessage(), e.getResultInfo().getData());
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo defaultExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("defaultExceptionHandler ==> " + e.getMessage());
        e.printStackTrace();
        String exceptionName = ClassUtils.getShortName(e.getClass());
        log.error("ExceptionName ==> " + exceptionName);
        return new ResultInfo(false, 9999, e.getMessage(), null);
    }
}
