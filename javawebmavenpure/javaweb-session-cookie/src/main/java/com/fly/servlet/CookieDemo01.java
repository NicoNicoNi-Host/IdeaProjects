package com.fly.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保在用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器,告诉你,你来的时间,把这个时间封装成为一个信件,你下带来,我就知道你来了
        // 编码问题，解决中文乱码
        req.setCharacterEncoding("utf-8");
        //Content-Type: text/html;charset=UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //服务器端从客户端获取cookies
        Cookie[] cookies = req.getCookies(); //获得Cookie，这里返回数组,说明Cookie可能存在多个

        //判断cookie是否存在
        if (cookies != null) {
            out.write("你上一次访问的时间是");
            for (Cookie cookie : cookies) { //从cookies中遍历得到lastLoginTime的cookie
                if (cookie.getName().equals("lastLoginTime")) {
                    //将代表时间的字符串转换为long
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    //将代表日期的long转化为日期格式
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }

        //服务给客户端响应一个cookie
        Cookie lastLoginTime = new Cookie("lastLoginTime", System.currentTimeMillis() + "");//新建一个cookie
        lastLoginTime.setMaxAge(24 * 60 * 60); //设置cookie的有效期为1天
        resp.addCookie(lastLoginTime); //响应给客户端一个cookie



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
    }
}
