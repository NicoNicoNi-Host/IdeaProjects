package com.fly.filter;

import com.fly.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    //初始化：web服务器启动，就以及初始化了，随时等待过滤对象出现！
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse
            resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req; //类型转换 ServletRequest转为HttpServletRequest
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession().getAttribute(Constant.USER_SESSION) == null) {
            response.sendRedirect("/motor/index.jsp"); //如果session为空，重定向，
        }
        chain.doFilter(request, response);
    }

    //销毁：web服务器关闭的时候，过滤会销毁
    public void destroy() {

    }
}