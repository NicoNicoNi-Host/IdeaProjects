package com.kuangstudy.net;

import java.net.InetSocketAddress;

public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new
                InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new
                InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());
        System.out.println(socketAddress2.getHostName());
        System.out.println(socketAddress2.getAddress()); //返回地址
        System.out.println(socketAddress2.getPort()); //返回端口
    }
}
