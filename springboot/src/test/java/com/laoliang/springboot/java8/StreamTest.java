package com.laoliang.springboot.java8;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author laoliangliang
 * @date 2019/10/29 14:44
 */
public class StreamTest {

    @Test
    public void streamHeader(){
        String[] arr = {"hello","world"};
        // 可传入数组或单值
        Stream<String> stringStream = Stream.of(arr);

        Stream.iterate(0, n -> n + 1).limit(5).forEach(System.out::print);
    }
}
