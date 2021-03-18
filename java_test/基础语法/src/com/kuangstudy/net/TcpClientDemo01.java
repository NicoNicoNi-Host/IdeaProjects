package com.kuangstudy.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 连接服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 8899;
            //2. 创建一个Socket
            socket = new Socket(serverIP, port);
            //3. 创建一个输出流，向外写东西
            os = socket.getOutputStream();
            os.write("你好,欢迎学习Java网络编程".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            try {
                if (os != null) {
                    os.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}