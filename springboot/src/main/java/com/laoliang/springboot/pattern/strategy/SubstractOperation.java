package com.laoliang.springboot.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:12
 */
@Component
public class SubstractOperation implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }

}
