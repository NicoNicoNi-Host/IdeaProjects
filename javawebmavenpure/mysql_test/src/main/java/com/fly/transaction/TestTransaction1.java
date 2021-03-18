package com.fly.transaction;

import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//模拟转账成功时的业务场景
public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
//            关闭数据库的自动提交,自动会开启事务
            conn.setAutoCommit(false);//通知数据库开启事务(start transaction)
            String sql1 = "update account set money=money-100 where name='A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "update account set money=money+100 where name='B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            conn.commit();//上面的两条SQL执行Update语句成功之后就通知数据库提交事务(commit)
            System.out.println("成功！！！"); //log4j
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}