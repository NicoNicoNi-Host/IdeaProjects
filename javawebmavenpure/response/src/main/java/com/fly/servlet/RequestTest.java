package com.fly.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class RequestTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理请求
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ":" + password);

        //重定向时候一定要注意，路径问题，否则404；
        if (username.equals("admin") && toHash(password) == -3990) {
            resp.sendRedirect("/response_war/success.jsp");
        } else {
            resp.sendRedirect("https://devinhalladay.com/404/");
        }
    }

    // 将字符串转成hash值,密码的确认不以明文出现
    public static int toHash(String key) {
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
    }
}
