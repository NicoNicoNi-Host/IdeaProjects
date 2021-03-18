package com.fly.servlet;

import com.fly.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到Session并在后台输出，若原本没有session报500 空指针异常
        HttpSession session = req.getSession();
//        String name = (String) session.getAttribute("name");
//        System.out.println(name);

        Person person = (Person) session.getAttribute("name");
        System.out.println(person.toString());
        resp.getWriter().write(person.toString());
    }
/*
  <!--设置Session默认的失效时间-->
  <session-config>
    <!--15分钟后Session自动失效，以分钟为单位-->
    <session-timeout>15</session-timeout>
  </session-config>
* */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

