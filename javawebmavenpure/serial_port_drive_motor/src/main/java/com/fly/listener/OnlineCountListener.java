package com.fly.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static com.fly.util.Constant.*;

//统计网站在线人数 ： 统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听： 看你的一举一动
//一旦创建Session就会触发一次这个事件！

        public void sessionCreated(HttpSessionEvent event) {
        ServletContext ctx = event.getSession().getServletContext();
        System.out.println(event.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute(ONLINE_SESSION);

        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        ctx.setAttribute(ONLINE_SESSION, onlineCount);

    }//销毁session监听

    //一旦销毁Session就会触发一次这个事件！
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute(ONLINE_SESSION);
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        ctx.setAttribute(ONLINE_SESSION, onlineCount);
    }
/*
Session销毁：
1. 手动销毁 getSession().invalidate();
2. 自动销毁
*/
}

