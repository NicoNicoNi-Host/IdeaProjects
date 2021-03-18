package com.fly.mysql;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where id=3";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}