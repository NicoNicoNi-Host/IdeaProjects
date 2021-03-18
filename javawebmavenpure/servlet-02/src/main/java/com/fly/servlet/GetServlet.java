package com.fly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        //获取保存在ServletContext中的对象

        String username = (String) context.getAttribute("username");
        //获取username，因为程序不知道对象类型，需要强制转换

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //编码问题

        resp.getWriter().print("名字" + username);
        //输出到网页上
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}