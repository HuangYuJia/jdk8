package com.kingsoft.jdk8.Test3_Function;

import java.time.temporal.ValueRange;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName FunctionTest2
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/12 23:23
 * @Version 1.0
 **/
public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 test2 = new FunctionTest2();
        System.out.println(test2.compute(2, value -> value * 3, value -> value * value));  // 12    3*(2*2)
        System.out.println(test2.compute2(2, value -> value * 3, value -> value * value));  // 36   (3*2)*(3*2)
        System.out.println(test2.compute3(1,2, (value1, value2) -> value1 + value2));
        System.out.println(test2.compute3(1,2, (value1, value2) -> value1 - value2));

        System.out.println(test2.compute4(2,3, (value1, value2) -> value1 + value2, value -> value + value));
    }

    private int compute(int i, Function<Integer, Integer> function1,Function<Integer, Integer> function2){
        return function1.compose(function2).apply(i);
    }

    private int compute2(int i, Function<Integer, Integer> function1,Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(i);
    }

    private int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a,b);
    }

    private int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer ,Integer> function){
        return biFunction.andThen(function).apply(a,b);   // (2+3)+(2+3)
    }

}
