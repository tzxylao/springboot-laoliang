package com.laoliang.springboot.pattern.strategy;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:10
 */
@FunctionalInterface
public interface CalculateStrategy {

    int doOperation(int num1,int num2);
}
