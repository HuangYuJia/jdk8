package com.kingsoft.jdk8.Test11_Stream;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @ClassName MySetCollector
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/25 23:03
 * @Version 1.0
 **/
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked...");
//        return HashSet::new;
        return () -> {
            System.out.println("------创建容器------------");
            return new HashSet<T>();
            /*
             *     A a1 = supplier.get();
             *     accumulator.accept(a1, t1);
             *     accumulator.accept(a1, t2);
             *     R r1 = finisher.apply(a1);
             *
             *     A a2 = supplier.get();
             *     accumulator.accept(a2, t1);
             *     A a3 = supplier.get();
             *     accumulator.accept(a3, t2);
             *     R r2 = finisher.apply(combiner.apply(a2, a3));
             */
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked...");
        return (set, item) -> {
            System.out.println("accumulator:" + set + ", 当前操作线程的名称:" + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked...");
        return (set1, set2) -> {
            System.out.println("set1: " + set1);
            System.out.println("set2: " + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked...");
        return set -> {
          Map<T, T> map = new TreeMap<>();
          set.stream().forEach(item -> map.put(item, item));
          return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked...");
        /*
        当使用parallelStream时,并且指定Characteristics.CONCURRENT,只有一个容器,多个线程在一个容器中进行操作,
        有可能会抛出java.util.ConcurrentModificationException, 因为不能同时对同一个结果容器既进行修改操作又进行遍历操作.
        For example, it is not generally permissible for one thread to modify a Collection
        while another thread is iterating over it.
         */
//        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
        /*
        当使用parallelStream时,并且没有指定Characteristics.CONCURRENT,会有多个线程在进行操作,每个线程对应一个容器
        不用担心出现java.util.ConcurrentModificationException.因为每个线程各自有对应的容器,线程数最大是cpu的核心数(包含超线程技术)
         */
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));

    }

    public static void main(String[] args) {
        // cpu核心数(包含超线程技术)
        System.out.println("cpu核心数(超线程技术)" + Runtime.getRuntime().availableProcessors());
        for(int i=0; i<1; ++i){
            List<String> list = Arrays.asList("hello", "hello", "world", "mingxuan", "linghan", "huhu", "han", "ke", "xixi", "huanhuan", "lerong");
            Set<String> set = new HashSet<>();
            set.addAll(list);
            System.out.println("set:" + set);
            Map<String, String> map = set.parallelStream().collect(new MySetCollector2<>());  // 并行流
            // Map<String, String> map = set.stream().parallel().collect(new MySetCollector2<>());  // 并行流
            // Map<String, String> map = set.stream().sequential().collect(new MySetCollector2<>());  // 串行流
            // Map<String, String> map = set.stream().collect(new MySetCollector2<>());  // 串行流
            // Map<String, String> map = set.stream().sequential().parallel().collect(new MySetCollector2<>());  // 并行流(以最后边一个为准)
            System.out.println(map);
        }
    }
}

//当使用parallelStream时,并且没有指定Characteristics.CONCURRENT,会有多个线程在进行操作,每个线程对应一个容器.
//当使用parallelStream时,并且指定Characteristics.CONCURRENT,只有一个容器,多个线程在一个容器中进行操作.
//有可能会抛出java.util.ConcurrentModificationException,因为不能同时对容器既进行修改操作又进行遍历操作.

