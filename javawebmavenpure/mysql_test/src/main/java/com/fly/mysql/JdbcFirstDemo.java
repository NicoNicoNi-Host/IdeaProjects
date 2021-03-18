package com.fly.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
*/
public class JdbcFirstDemo {
    public static void main(String[] args) throws Exception {
//用户信息和URL
//要连接的数据库URL，用问号连接参数：支持中文编码、使用UTF-8安全字符集、不使用安全连接
        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
//连接的数据库时使用的用户名
        String username = "root";
//连接的数据库时使用的密码
        String password = "12345678";

//1.加载驱动
//DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
        Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
//2.获取与数据库的链接
        Connection conn = DriverManager.getConnection(url, username, password);
//3.获取用于向数据库发送sql语句的statement
        Statement st = conn.createStatement();
        String sql = "select id,name,password,email,birthday from users";
//4.向数据库发sql,并获取代表结果集的resultset
        ResultSet rs = st.executeQuery(sql);
//5.取出结果集的数据
        while (rs.next()) {
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
            System.out.println("=====================================================");
        }
//6.关闭链接，释放资源
        rs.close();
        st.close();
        conn.close();

//----------------------------------------------------------------------

/*
//        1．加载驱动
        Class.forName ("com.mysql.jdbc.Driver"); //固定写法,加裁驱动
//        2。用户信息Aurl
//        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String url = "jdbc:mysql://localhost:3306/jdbcStudy";
//连接的数据库时使用的用户名
        String username = "root";
//连接的数据库时使用的密码
        String password = "12345678";

//        3,连接成功,数据库对象Connection代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
//        4,执行SQL的对象Statement执行sqL的对象
        Statement statement = connection.createStatement();
//        5.执行SQL的对象去执行QL,可能存在结果,查看返回结果
        String sql ="SELECT * FROM users";
        ResultSet resultSet = statement. executeQuery(sql); //返回的结果集,结果集中封装了我们全部的查询出来的结果
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("=====================================================");
        }
//        6.关闭链接，释放资源
        resultSet.close();
        statement.close();
        connection.close();
        */
    }
}


