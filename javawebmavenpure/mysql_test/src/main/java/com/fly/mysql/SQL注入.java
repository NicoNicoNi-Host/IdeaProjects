package com.fly.mysql;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;

/*

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class SQL注入 {
    public static void main(String[] args) {
// login("zhangsan","123456"); // 正常登陆
        login("'or '1=1", "'or '1=1"); // SQL 注入
    }

    public static void login(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
// select * from users where name='' or '1=1' and password =''or '1=1'  //因为1=1绝对成立，且前面是or 所以成功注入
            String sql = "select * from users where name='" + username + "' and password='" + password + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println("==============");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
*/


import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SQL注入 {
//    避免sql注入
    public static void main(String[] args) {
// login("zhangsan","123456"); // 正常登陆
        login("'or '1=1","12345678"); // SQL 注入
    }
    public static void login(String username,String password){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
// select * from users where name='' or '1=1' and password ='123456'
            String sql = "select * from users where name=? and password=?";
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                System.out.println("==============");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}