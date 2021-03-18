package com.fly.filter;

import com.fly.pojo.HashUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.fly.util.Constant.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取前端请求的参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

/*
        判断是否直接输入url访问
        不能使用username.equals("") || pwd.equals("") 或 username.equals(null) || pwd.equals(null)
        会报空指针异常 java.lang.NullPointerException
        直接点击登录按钮username和pwd的值为 "" ，不能在这里处理，否则发生直接输入url的情况会发生空指针异常
*/
        if (username == null || pwd == null) {
            resp.sendRedirect("index.jsp");
        } else if (HashUtil.hash(username, "MD5").equals(USERNAME) &&
                HashUtil.hash(pwd, "SHA1").equals(PASSWORD)) {
/*
        登录成功  用户名和密码见常量类
        验证分别使用hash算法字符串的MD5值和hash算法字符串的SHA1值
*/
            req.getSession().setAttribute(USER_SESSION, req.getSession().getId());
            resp.sendRedirect("sys/success.jsp"); //重定向，不暴露登录页面的url
//            req.getRequestDispatcher("sys/success.jsp").forward(req, resp);//转发，不暴露电机控制页面的url
        } else {//登录失败
//            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            resp.sendRedirect("index.jsp");
/*
        用户名密码错误或直接点击"登录"按钮的处理
*/
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
