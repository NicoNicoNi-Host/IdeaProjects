package com.fly.mysql;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "update users set name='kuangshen',email='24736743@qq.com' where id=3";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
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