package com.fly.filter_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.fly.util.Constant.USER_SESSION;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object user_session = req.getSession().getAttribute(USER_SESSION);

        if (user_session != null) {
            req.getSession().removeAttribute(USER_SESSION);
            resp.sendRedirect("Login.jsp");
        } else {
            resp.sendRedirect("Login.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
    }
}
