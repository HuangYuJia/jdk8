package com.kingsoft.jdk8.Test2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StringComparator
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/12 22:58
 * @Version 1.0
 **/
public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan","lisi","wangwu");
        // 方式一:
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        System.out.println(names);

        // 方式二:  statement  { return o2.compareTo(o1); }
//        Collections.sort(names, (String o1, String o2) -> {
//            return o2.compareTo(o1);
//        });
//        System.out.println(names);

        // 方式三:  expression  o2.compareTo(o1)
//        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
//        System.out.println(names);

        // 方式四:
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);

    }
}
