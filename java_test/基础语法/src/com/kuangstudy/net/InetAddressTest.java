package com.kuangstudy.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//IP 这个东西，怎么用Java对象表示
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //获得IP地址
            InetAddress inetAddresses1 = InetAddress.getByName("192.168.8.123");
            System.out.println(inetAddresses1);// /192.168.8.123
            InetAddress inetAddresses2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddresses2);// www.baidu.com/182.61.200.7

            //获取本地IP
            InetAddress inetAddresses3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddresses3);// /127.0.0.1
            InetAddress inetAddresses4 = InetAddress.getByName("localhost");
            System.out.println(inetAddresses4); // localhost/127.0.0.1
            InetAddress inetAddresses5 = InetAddress.getLocalHost();
            System.out.println(inetAddresses5);//AndrewdeMacBook-Pro.local/127.0.0.1

            //getHostName
            System.out.println(inetAddresses2.getHostName());//www.baidu.com
            //getHostAddress
            System.out.println(inetAddresses2.getHostAddress());//182.61.200.7
            //Canonical : 规范的
            System.out.println(inetAddresses2.getCanonicalHostName()); //182.61.200.7
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
