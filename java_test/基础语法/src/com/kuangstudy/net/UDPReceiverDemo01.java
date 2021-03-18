package com.kuangstudy.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiverDemo01 {
    public static void main(String[] args) throws Exception {
//1. 建立DatagramSocket,开放端口
        DatagramSocket socket = new DatagramSocket(9090);
//2. 接收数据
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
//3. 输出数据
// packet.getData() : 获取packet中的数据
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
//4. 关闭socket
        socket.close();
    }
}