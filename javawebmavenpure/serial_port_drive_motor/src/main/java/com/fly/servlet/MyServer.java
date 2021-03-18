package com.fly.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServer extends HttpServlet {
    public static String statusStr = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //使用过滤器设置中文编码

        // 获取参数
        String parameter = req.getParameter("parameter");
        String on_1 = req.getParameter("on_1");
        String on_2 = req.getParameter("on_2");
        String off = req.getParameter("off");
        String status = req.getParameter("status");

        String port = req.getParameter("port"); //控制端口 ，默认COM3
        Integer baudrate = Integer.valueOf(req.getParameter("baudrate")); //波特率，默认9600

        System.out.println("选中串口为：" + port + "  " + "波特率为：" + baudrate);

        try {
            if (null == parameter || "".equals(parameter)) {
                System.out.println("接收到的参数为空！");
            } else {
                if ("on_1".equals(parameter)) {
//                    Tools.action(on_1);
//                    Tools.action(on_1, port, baudrate);
                    statusStr = Tools.action(on_1, port, baudrate);
                } else if ("on_2".equals(parameter)) {
//                    Tools.action(on_2);
//                    Tools.action(on_2, port, baudrate);
                    statusStr = Tools.action(on_2, port, baudrate);
                } else if ("status".equals(parameter)) {
                    statusStr = Tools.action(status, port, baudrate);

                } else {
//                    Tools.action(off);
                    statusStr = Tools.action(off, port, baudrate);
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Tools.closePort();
        }

//        req.getRequestDispatcher("sys/success.jsp").forward(req, resp);//转发
        resp.sendRedirect("sys/success.jsp"); //重定向;不暴露url，就不需要设置登录过滤器

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
}