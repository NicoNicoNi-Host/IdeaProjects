package com.fly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.getInitParameter() //获得初始化参数，在web.xml中，输入一个尖括号< IDEA会自动联想出所有参数
        //this.getServletConfig() //Servlet配置
        //this.getServletContext()// Servlet上下文

        ServletContext context = this.getServletContext(); //根据IDEA提示，getServletContext()方法返回类型为ServletContext
        //故定义一个ServletContext类型


        String username = "Andrew"; //数据;若为中文，需要处理网页编码问题
        context.setAttribute("username", username);
        //将一个数据保存在了ServletContext中，名字为："username" 。值 username

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
