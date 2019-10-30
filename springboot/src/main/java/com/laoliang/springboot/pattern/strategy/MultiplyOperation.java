package com.laoliang.springboot.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:13
 */
@Component
@Slf4j
public class MultiplyOperation implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        log.info("====> doOperation 进入");
        return num1 * num2;
    }

}
