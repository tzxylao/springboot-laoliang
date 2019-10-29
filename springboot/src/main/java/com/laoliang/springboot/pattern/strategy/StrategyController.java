package com.laoliang.springboot.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:52
 */
@RestController
public class StrategyController {

    @Autowired
    private CalculatelOperationContext calculatelOperationContext;

    @RequestMapping(value = "/operation")
    public String strategySelect(@RequestParam("mode") String mode) {
        return String.valueOf(calculatelOperationContext.strategySelect(mode).doOperation(20, 5));
    }
}
