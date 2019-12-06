package com.laoliang.springboot.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;

/**
 * @ClassName Learn
 * @Descriiption TODO
 * @Author laoliangliang
 * @Date 2019/11/21 13:57
 **/
public class Learn {

    @Test
    public void convertTest(){
        String convert = Convert.convert(String.class, 1);
        System.out.println(convert);
    }
}
