package com.fly.transaction;

import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 模拟转账过程中出现异常导致有一部分SQL执行失败后让数据库自动回滚事务
public class TestTransaction2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);//通知数据库开启事务(start transaction)
            String sql1 = "update account set money=money-100 where name='A'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
//用这句代码模拟执行完SQL1之后程序出现了异常而导致后面的SQL无法正常执行，事务也无法正常提交，此时数据库会自动执行回滚操作
            int x = 1 / 0;
            String sql2 = "update account set money=money+100 where name='B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            conn.commit();//上面的两条SQL执行Update语句成功之后就通知数据库提交事务(commit)
            System.out.println("成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
