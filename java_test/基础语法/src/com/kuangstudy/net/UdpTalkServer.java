package com.kuangstudy.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            try {
//准备接收包裹；
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0,
                        container.length);
                socket.receive(packet); //阻塞式接收包裹
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas, 0, len);
                System.out.println(data);
                //退出判断
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}