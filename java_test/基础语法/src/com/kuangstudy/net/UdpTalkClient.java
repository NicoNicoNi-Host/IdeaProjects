package com.kuangstudy.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpTalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中....");
//1. 使用DatagramSocket 指定端口，创建发送端
        DatagramSocket socket = new DatagramSocket(8888);
//2. 准备数据，转成字节数组
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
//3. 封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                    new InetSocketAddress("localhost", 6666));
//4. 发送包裹send
            socket.send(packet);
//退出判断
            if (data.equals("bye")) {
                break;
            }
        }
//5. 释放资源
        socket.close();
    }
}