package com.fly.Thread;

public class TestThread3 implements Runnable {

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("运行run方法" + i);
        }
    }

    public static void main(String[] args) {
//创建runnbale 接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
//创建线程对象,通过线程对象来开启我们的线程,代理
//        Thread thread = new Thread(testThread3);
//        thread.start();

        new Thread(testThread3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("运行主线程" + i);
        }
    }
}
