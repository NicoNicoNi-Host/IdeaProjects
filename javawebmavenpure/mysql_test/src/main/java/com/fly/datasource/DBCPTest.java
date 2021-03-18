package com.fly.datasource;


import com.fly.utils.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
public class DBCPTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
//获取数据库连接
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setInt(1, 7);//id是int类型的
            st.setString(2, "kuangshen");//name是varchar(字符串类型)
            st.setString(3, "123");//password是varchar(字符串类型)
            st.setString(4, "24736743@qq.com");//email是varchar(字符串类型)
            st.setDate(5, new java.sql.Date(new
                    Date().getTime()));//birthday是date类型
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
//释放资源
            JdbcUtils_DBCP.release(conn, st, rs);
        }
    }
}