package com.kingsoft.jdk8.Test11_Stream;


import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest6 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.empty();
        stream.findFirst().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        Stream<String> stream1 = Stream.generate(UUID.randomUUID()::toString);
        stream1.findFirst().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        // Stream.iterate(1, item -> item + 2)会无限循环
        Stream.iterate(1, item -> item + 2).limit(3).forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");

        Stream<Integer> stream2 = Stream.iterate(1, item -> item + 2).limit(6); // 1 3 5 7 9 11  ==>>  14 + 18 = 32
        System.out.println(stream2.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());
        System.out.println("---------------华丽丽的分割线------------------------");
        Stream<Integer> stream3 = Stream.iterate(1, item -> item + 2).limit(6);
        stream3.filter(item -> item > 3).mapToInt(item -> item * 2).skip(2).limit(2).max().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        Stream<Integer> stream4 = Stream.iterate(1, item -> item + 2).limit(6);
        // 没有符合的结果,不打印输出,也不会抛出异常
        stream4.filter(item -> item > 200).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------------");
        // 获取平均值最大值最小值等信息
        Stream<Integer> stream5 = Stream.iterate(1, item -> item + 2).limit(6);
        IntSummaryStatistics summaryStatistics = stream5.filter(item -> item > 2).
                mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println("---------------华丽丽的分割线------------------------");
        // Stream<Integer> stream6 = Stream.iterate(1, item -> item + 2).limit(6);
        // stream has already been operated upon or closed
        // System.out.println(stream6);
        // System.out.println(stream6.filter(item -> item > 2));
        // System.out.println(stream6.distinct());
        System.out.println("---------------华丽丽的分割线------------------------");
        Stream<Integer> stream7 = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream7);
        Stream<Integer> stream8 = stream7.filter(item -> item > 2);
        System.out.println(stream8);
        Stream<Integer> stream9 = stream8.distinct();
        System.out.println(stream9);
    }
}
