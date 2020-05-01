package com.kingsoft.jdk8.Test11_Stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest15
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/5/1 22:16
 * @Version 1.0
 **/
public class StreamTest15 {
    // Stream -> BaseStream -> AutoCloseable
    // 程序执行完调用close()释放资源并触发onClose()方法,该方法可以有多个,按照先后顺序进行执行,其中抛抛出异常依旧继续执行,第一个异常抛给用户,其余异常当成压制异常处理
    // 同一个异常对象都抛出并只显示一个异常信息
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        NullPointerException nullPointerException = new NullPointerException("my exception");
        try(Stream<String> stream = list.stream()){
            stream.onClose(() -> {
                System.out.println("onClose1...");
                // throw new NullPointerException("first exception");
                // throw nullPointerException;
                throw new NullPointerException("first exception");
            }).onClose(() -> {
                System.out.println("onClose2...");
                // 第一个异常抛给用户,其余异常当成压制异常处理 Suppressed: java.lang.ArithmeticException: second exception
                // throw new ArithmeticException("second exception");
                // throw nullPointerException;
                throw new NullPointerException("second exception");
            }).forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
