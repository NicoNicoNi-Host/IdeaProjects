package com.fly.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.fly.util.Constant.*;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object user_session = req.getSession().getAttribute(USER_SESSION);

        if (user_session != null) {
            req.getSession().removeAttribute(USER_SESSION); //删除用户登录
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
