package com.fly.mysql;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
*/
import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TestSelect_2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            rs = st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e) {
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}