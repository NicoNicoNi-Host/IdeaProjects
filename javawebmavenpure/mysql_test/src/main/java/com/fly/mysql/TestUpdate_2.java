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
public class TestUpdate_2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "update users set name=?,email=? where id=?";
            st = conn.prepareStatement(sql);
            st.setString(1, "kuangshen");
            st.setString(2, "24736743@qq.com");
            st.setInt(3, 2);
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("更新成功！！");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}