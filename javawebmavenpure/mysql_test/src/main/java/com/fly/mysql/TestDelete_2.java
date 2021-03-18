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
public class TestDelete_2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "delete from users where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 4);
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("删除成功！！");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}