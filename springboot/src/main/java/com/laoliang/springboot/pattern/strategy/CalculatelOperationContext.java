package com.laoliang.springboot.pattern.strategy;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laoliangliang
 * @date 2019/10/28 10:14
 */
@Component
public class CalculatelOperationContext {

    private final Map<String, CalculateStrategy> strategyMap = new ConcurrentHashMap<>();

    @Autowired
    public void stragegyInteface(Map<String, CalculateStrategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach(this.strategyMap::put);
        System.out.println(this.strategyMap);
    }


    @Autowired
    public void stragegyInteface2(List<CalculateStrategy> strategyMap) {
        strategyMap.forEach(System.out::println);
    }

    public CalculateStrategy strategySelect(String mode) {
        Preconditions.checkArgument(!StringUtils.isEmpty(mode), "不允许输入空字符串");
        return this.strategyMap.get(mode);
    }
}
