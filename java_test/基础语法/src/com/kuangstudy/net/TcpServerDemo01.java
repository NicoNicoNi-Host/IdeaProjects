package com.kuangstudy.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;//不放在try里面 提升作用域
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1. 开放服务器端口，创建ServerSocket
            serverSocket = new ServerSocket(8899);
            //2. 等待客户端的连接
            accept = serverSocket.accept();
            //3. 读入客户端的消息,
            is = accept.getInputStream();
/*
回忆之前的IO流方案，弊端：存在中文，可能存在乱码。
byte[] buffer = new byte[1024];
int len;
while ((len=is.read(buffer))!=-1){
String str = new String(buffer,0,len);
System.out.println(str);
}
**/
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println(
                    "数据来源地址：" + accept.getInetAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源，先开后关 栈
            try {//四个关闭资源都需要报异常，一次性报了
                if (baos != null) {
                    baos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}