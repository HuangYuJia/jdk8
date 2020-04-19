package com.kingsoft.jdk8.Test11_Stream;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/18 16:37
 * @Version 1.0
 **/

public class StreamTest9 {
    // 并发流和串行流
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; ++i){
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序了");
        // 纳秒
        long start_time = System.nanoTime();

        // 串行流stream()
        // list.stream().sorted().count();  // 排序耗时:4517
        // 并行流parallelStream()
        list.parallelStream().sorted().count();  // 排序耗时:1854

        long end_time = System.nanoTime();
        long need_millis_time = TimeUnit.NANOSECONDS.toMillis(end_time - start_time);
        System.out.println("排序耗时:" + need_millis_time);
    }
}


