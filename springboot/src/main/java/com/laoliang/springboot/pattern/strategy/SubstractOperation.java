package com.laoliang.springboot.pattern.strategy;

import com.laoliang.springboot.common.ResultInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:12
 */
@Component
public class SubstractOperation implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        ResultInfo.error("相减异常",new BigDecimal("110000"));
        return num1 - num2;
    }

}
