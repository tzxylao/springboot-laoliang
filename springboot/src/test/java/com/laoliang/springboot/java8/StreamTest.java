package com.laoliang.springboot.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author laoliangliang
 * @date 2019/10/29 14:44
 */
public class StreamTest {

    @Test
    public void streamIterate() {
        String[] arr = {"hello", "world"};
        // 可传入数组或单值
        Stream<String> stringStream = Stream.of(arr);

        Stream.iterate(0, n -> n + 1).limit(5).forEach(System.out::print);

        System.out.println("---------");

        AtomicInteger n = new AtomicInteger();
        Stream.generate(n::getAndIncrement).limit(5).forEach(System.out::print);

        System.out.println("---------");

        List<String> strings = Arrays.asList("hello", "world");
        strings.stream().forEach(System.out::print);
    }

    /**
     * filer
     * Predicate
     * Stream
     * 过滤数据
     * <p>
     * <p>
     * distinct
     * 无
     * Stream
     * 去重
     * <p>
     * <p>
     * map
     * Function
     * Stream
     * 返回新的数据
     * <p>
     * <p>
     * flatMap
     * Function
     * Stream>
     * 返回新的数据，并做扁平化处理
     * <p>
     * <p>
     * sort
     * Comparator
     * Stream
     * 对数据进行排序操作
     * <p>
     * <p>
     * limit
     * long
     * Stream
     * 截取前几条数据
     * <p>
     * <p>
     * skip
     * long
     * Stream
     * 跳过几条数据
     * <p>
     * <p>
     * anyMatch
     * Predicate
     * boolean
     * 匹配任意一条数据，如果匹配到返回true
     * <p>
     * <p>
     * noneMatch
     * Predicate
     * boolean
     * 如果没有匹配到数据，返回true
     * <p>
     * <p>
     * allMatch
     * Predicate
     * boolean
     * 如果所有数据全部匹配到，返回true
     * <p>
     * <p>
     * findAny
     * 无
     * Optional
     * 返回任意一条数据
     * <p>
     * <p>
     * findFirst
     * 无
     * Optional
     * 返回第一条数据
     * <p>
     * <p>
     * count
     * 无
     * long
     * 返回元素个数
     * <p>
     * <p>
     * forEach
     * Consumer
     * void
     * 遍历元素，执行Consumer
     * <p>
     * <p>
     * collect
     * Collector
     * R
     * 元素收集
     * <p>
     * <p>
     * reduce
     * BinaryOperator
     * Optional
     * 数据汇总
     */
    @Test
    public void streamOperator() {
        Integer[] arr = {1, 7, 6, 2, 8, 3, 4, 5, 9, 8, 9};
        long count = Stream.of(arr).filter(i -> i % 2 == 0).count();
        System.out.println("偶数数量：" + count);

        // 表示符合条件的任意元素，找不到则返回0
        Integer num = Stream.of(arr).filter(i -> i % 2 == 0).findAny().orElse(0);
        System.out.println("findAny:" + num);

        // 去重
        Stream.of(arr).distinct().forEach(System.out::print);

        System.out.println();
        System.out.println("---------");
        // 倒序排列
        Stream.of(arr).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        System.out.println("---------");

        // map取出属性组成新的Stream
        List<Good> goods = Arrays.asList(new Good("iphone11", 11000),
                new Good("iphoneX", 10000),
                new Good("Nova 5z", 1799));
        goods.stream().map(Good::getName).forEach(System.out::println);
        System.out.println("---------");

        // 组成集合
        List<String> collect = goods.stream().map(Good::getName).collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("---------");
        Stream.of("I am Jim", "hello world").flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::print);
        System.out.println();
        System.out.println("---------");

        Stream<String[]> stream = Stream.of("I am Jim", "hello world").map(s -> s.split(" "));
        System.out.println(Arrays.toString(stream.toArray()));
        System.out.println("---------");

        System.out.println("test master");
    }
}
