package com.fly.filter_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.fly.util.Constant.USER_SESSION;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //后台接收中文乱码问题
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().write("你好，世界");
        //获取前端请求的参数
        String username = req.getParameter("username");
        if (username.equals("admin")) {//登录成功
            req.getSession().setAttribute(USER_SESSION, req.getSession().getId());
//            resp.sendRedirect("/success.jsp");
            req.getRequestDispatcher("/sys/success.jsp").forward(req, resp);


        } else {//登录失败
//            resp.sendRedirect("/error.jsp");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);

        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
