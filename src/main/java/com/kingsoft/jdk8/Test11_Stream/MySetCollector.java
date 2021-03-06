package com.kingsoft.jdk8.Test11_Stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @ClassName MySetCollector
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/25 23:03
 * @Version 1.0
 **/
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked...");
        return HashSet::new;

    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked...");
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked...");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
//        System.out.println("finisher invoked...");
//        return Function.identity();
        throw new UnsupportedOperationException();  // 可直接抛出异常...再这里也不会被调用到
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked...");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        Set<String> set = list.stream().collect(new MySetCollector<>());
        System.out.println(set);
    }
}
