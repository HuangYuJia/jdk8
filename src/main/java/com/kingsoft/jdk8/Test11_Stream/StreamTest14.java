package com.kingsoft.jdk8.Test11_Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StreamTest14
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/25 13:07
 * @Version 1.0
 **/
public class StreamTest14 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("linghan", "yujia", "hello", "girl", "boy");
        // Collections.sort(list);  // 默认按照ASCII码排序
        // Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
        // Collections.sort(list, (item1, item2) -> item2.length() - item1.length());
        // Collections.sort(list, Comparator.comparing(String::length).reversed());
        /**
         * 编译不通过,编译器把item的类型识别为Object,因为识别不了内层item -> item.length()【ToIntFunction<? super T>】的类型,外层是reversed()【Comparator<T>】
         * public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
         * Comparator<T> reversed()
         * Collections.sort(list, Comparator.comparingInt(item -> item.length()).reversed());
         * 需要强制指定类型
         */
        // Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());
        // Collections.sort(list, Comparator.comparingInt((Object item) -> 1).reversed());
        // list.sort(Comparator.comparingInt(String::length).reversed());
        // list.sort(Comparator.comparingInt((String item) -> item.length()).reversed());
        // Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        // Collections.sort(list, Comparator.comparingInt(String::length).
        //        thenComparing((item1, item2) -> item1.toLowerCase().compareTo(item2.toLowerCase())));

        // Collections.sort(list, Comparator.comparingInt(String::length).
        //        thenComparing(Comparator.comparing(String::toLowerCase)));

        // Collections.sort(list, Comparator.comparingInt(String::length).
        //        thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));

        // Collections.sort(list, Comparator.comparingInt(String::length).reversed().
        //         thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));
        // System.out.println(list);

        // 如果前边的比较结果为0(相等),则将相等部分调用thenComparing中的比较器再次进行比较,
        // 如果前边的比较结果非0(不相等),则thenComparing中的比较器不生效
        Collections.sort(list, Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())).
                thenComparing(Comparator.reverseOrder()));

        System.out.println(list);

    }
}
