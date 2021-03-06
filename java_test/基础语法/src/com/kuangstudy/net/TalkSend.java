package com.kuangstudy.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//发送端
public class TalkSend implements Runnable {
    private DatagramSocket socket;
    private BufferedReader reader;
    private String toIP;
    private int toPort;

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
//3. 封装成DatagramPacket包裹，需要指定目的地
                DatagramPacket packet = new
                        DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));
//4. 发送包裹send
                socket.send(packet);
                //退出判断
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//5. 释放资源
        socket.close();
    }
}