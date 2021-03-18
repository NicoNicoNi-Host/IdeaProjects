package com.fly.mysql;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from users where id=4";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}