package com.kuangstudy.net;

import java.net.MalformedURLException;
import java.net.URL;
public class URLDemo01 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/helloworld/index.jsp? username=fly&password=123");
                    System.out.println(url.getProtocol()); //获取URL的协议名
            System.out.println(url.getHost()); //获取URL的主机名
            System.out.println(url.getPort()); //获取URL的端口号
            System.out.println(url.getPath()); //获取URL的文件路径
            System.out.println(url.getFile()); //获取URL的文件名
            System.out.println(url.getQuery()); //获取URL的查询名 参数
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

/*
http
localhost
8080
/helloworld/index.jsp
/helloworld/index.jsp? username=fly&password=123
 username=fly&password=123
*/
