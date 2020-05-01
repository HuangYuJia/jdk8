package com.kingsoft.jdk8.Test11_Stream;

/**
 * @ClassName AutoCloseableTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/5/1 22:06
 * @Version 1.0
 **/
public class AutoCloseableTest  implements AutoCloseable{

    public void dosomething(){
        System.out.println("dosomething invoked...");
    }


    @Override
    public void close() throws Exception {
        System.out.println("close invoked....");
    }

    public static void main(String[] args) throws Exception {
        // try-with-resources statement. 代替传统的 try catch finally
        // 传统操作io等时需要在finally中进行io流释放,使用try with resource语法程序执行完自动调用close()方法释放资源,必须是close()方法
        try(AutoCloseableTest autoCloseableTest = new AutoCloseableTest()){
            autoCloseableTest.dosomething();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
