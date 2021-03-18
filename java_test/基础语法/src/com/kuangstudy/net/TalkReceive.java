package com.kuangstudy.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端
public class TalkReceive implements Runnable {
    private DatagramSocket socket;
    private String msgFrom; //消息来源；如：老师、学生

    public TalkReceive(int port, String msgFrom) {
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
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
                System.out.println(msgFrom + ":" + data);
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
