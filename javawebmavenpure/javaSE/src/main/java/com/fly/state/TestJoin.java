package com.fly.state;


public class TestJoin implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP来了...." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);

        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                thread.join(); //插队，main线程阻塞
            }
            System.out.println("main..." + i);
        }
    }
}
