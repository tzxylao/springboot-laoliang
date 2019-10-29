package com.laoliang.springboot.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:11
 */
@Component
public class AddOperation implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        throw new RuntimeException("相加异常");
//        return num1 + num2;
    }

}
