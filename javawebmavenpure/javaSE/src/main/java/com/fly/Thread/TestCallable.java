package com.fly.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url; //网络图片地址
    private String name; //保存的文件名
    private static String path="javaSE/src/main/resources/";
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() {
        WebDownloader_2 webDownloader = new WebDownloader_2();
        webDownloader.downloader(url, name);
        System.out.println("已下载文件名 : " + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable(
                "https://i2.hdslb.com/bfs/face/ab24d03e1ee192861e62a149e517dcdb29be34dc.jpg@96w_96h_1c.jpg",
                path+"1.jpg");
        TestCallable t2 = new TestCallable(
                "https://i1.hdslb.com/bfs/face/e17014d4a3c4cc690735f952658320b9c837eed3.jpg@96w_96h_1c.jpg",
                path+"2.jpg");

//        4. 创建执行服务:
    ExecutorService ser= Executors.newFixedThreadPool(2);
//        5. 提交执行:
    Future<Boolean> r1=ser.submit(t1);
    Future<Boolean> r2=ser.submit(t2);

//        6. 获取结果:
    boolean rs1=r1.get();
    boolean rs2=r2.get();
//        7. 关闭服务:
    ser.shutdownNow();

    }
}

//下载器
class WebDownloader_2 {
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

