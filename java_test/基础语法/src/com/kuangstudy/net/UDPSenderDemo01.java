package com.kuangstudy.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSenderDemo01 {
    public static void main(String[] args) throws Exception {
//1. 建立DatagramSocket
        DatagramSocket socket = new DatagramSocket();
//2. 封装数据包
        String msg = "UDPSender==>";
        byte[] data = msg.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,port);
//3. 通过 Socket 发送 packet
        socket.send(packet);
//4. 关闭socket
        socket.close();
    }
}
