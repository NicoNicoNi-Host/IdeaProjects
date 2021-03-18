package com.fly.Thread;

public class TestThread1 extends Thread {
    @Override
    public void run() {
//        run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("运行run方法"+i);
        }
    }

    public static void main(String[] args) {
//        主线程

//        创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
//        调用start方法,开启线程
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("运行主线程"+i);
        }
    }
}
