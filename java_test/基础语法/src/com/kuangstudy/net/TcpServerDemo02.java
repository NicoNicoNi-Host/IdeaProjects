package com.kuangstudy.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
//1. 开启 ServerSocket
        ServerSocket serverSocket = new ServerSocket(9090);
//2. 侦听 客户端 Socket ；阻塞式监听,会一直等待客户端连接
        Socket socket = serverSocket.accept();
//3. 获取输入流
        InputStream is = socket.getInputStream();
//4. 读取接收的文件并保存
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        //通知客户端接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("Roger".getBytes());
//5.关闭资源,应该使用 try-catch-finally
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}