package com.kuangstudy.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception{
//1. 创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
//2. 创建一个输出流
        OutputStream os = socket.getOutputStream();
//3. 读取文件
        FileInputStream fis = new FileInputStream(new File("img.png"));
//4. 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
//告诉服务器，我传输完了,关闭数据的输出，不然就会一直阻塞！
        socket.shutdownOutput();
//先别着急关，等待服务器响应，响应到控制台，注意重复的变量问题！
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());
//5. 资源关闭,应该使用 try-catch-finally
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}