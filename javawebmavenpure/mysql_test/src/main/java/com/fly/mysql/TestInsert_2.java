package com.fly.mysql;

/*
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
*/
import com.fly.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
public class TestInsert_2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
//获取一个数据库连接
            conn = JdbcUtils.getConnection();
//要执行的SQL命令，SQL中的参数使用?作为占位符
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
//通过conn对象获取负责执行SQL命令的prepareStatement对象
            st = conn.prepareStatement(sql); //预编SQL,先写sql.然后不执行
//为SQL语句中的参数赋值，注意，索引是从1开始的
            st.setInt(1, 4);//id是int类型的
            st.setString(2, "kuangshen");//name是varchar(字符串类型)
            st.setString(3, "123");//password是varchar(字符串类型)
            st.setString(4, "24736743@qq.com");//email是varchar(字符串类型)

            //注意点: sql.Date 数据库
            //util.Date Java
            st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday是date类型
//执行插入操作，executeUpdate方法返回成功的条数
            int num = st.executeUpdate();
            if(num>0){
                System.out.println("插入成功！！");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
//SQL执行完成之后释放相关资源
            JdbcUtils.release(conn, st, rs);
        }
    }
}