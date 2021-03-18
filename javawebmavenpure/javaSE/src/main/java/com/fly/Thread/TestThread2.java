package com.fly.Thread;

//练习Thread ,实现多线程同步下载图片

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread implements Runnable {
    private String url; //网络图片地址
    private String name; //保存的文件名
    private static String path="javaSE/src/main/resources/";
    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("已下载文件名 : " + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2(
                "https://i2.hdslb.com/bfs/face/ab24d03e1ee192861e62a149e517dcdb29be34dc.jpg@96w_96h_1c.jpg",
                path+"1.jpg");
        TestThread2 t2 = new TestThread2(
                "https://i1.hdslb.com/bfs/face/e17014d4a3c4cc690735f952658320b9c837eed3.jpg@96w_96h_1c.jpg",
                path+"2.jpg");

        t1.start();//继承
        t2.start();

//        new Thread(t1).start();//实现接口
//        new Thread(t2).start();
    }
}

//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常.downloader方法出现问题");
        }
    }
}