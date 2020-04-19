package com.kingsoft.jdk8.Test11_Stream;


import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/
public class StreamTest4 {

    public static void main(String[] args) {
        /**
         *
         *  <A> A[] toArray(IntFunction<A[]> generator);
         *
         *  @FunctionalInterface
         *  public interface IntFunction<R> {
         *      R apply(int value);
         *  }
         */
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        // 把stream流转为数组
        // String[] stringArray = stream.toArray(length -> new String[length]); // lambda
        String[] stringArray = stream.toArray(String[]::new);      // 方法引用
        // 把数组转为list遍历输出
        Arrays.asList(stringArray).forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");
        // 把流直接转为list
        List<String> list1 = stream1.collect(Collectors.toList());
        list1.forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        /**
         *  public static <T>
         *   Collector<T, ?, List<T>> toList() {
         *      return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
         *      (left, right) -> { left.addAll(right); return left; },
         *      CH_ID);
         *   }
         */
        Stream<String> stream2 = Stream.of("hello", "world", "hello world");
        List<String> list2 = stream2.collect(() -> new ArrayList(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        list2.forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        Stream<String> stream3 = Stream.of("hello", "world", "hello world");
        List<String> list3 = stream3.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list3.forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        Stream<String> stream4 = Stream.of("hello", "world", "helloworld");
        List<String> list = stream4.collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        Stream<String> stream5 = Stream.of("hello", "world", "helloworld");
        Set<String> set = stream5.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set.getClass());
        set.forEach(System.out::println);
        System.out.println("---------------华丽丽的分割线------------------");
        Stream<String> stream6 = Stream.of("hello", "world", "boy");
        String str = stream6.collect(Collectors.joining()).toString();
        System.out.println(str);
    }

}
