package com.fly.state;


public class TestDeamon {


    public static void main(String[] args) throws InterruptedException {
        You you = new You();
        God god = new God();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //就认是false表示是用户线程,正常的线程都是用户线程..
        thread.start();//上帝守护线程启动

        new Thread(you).start();
    }
}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心地活着ing");
        }
        System.out.println("======GoodBye,World======");

    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("守护");
        }
    }
}