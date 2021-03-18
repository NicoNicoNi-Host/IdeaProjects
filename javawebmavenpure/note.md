web.xml  头文件对应tomcat的头文件，新版本IDEA不用替换也可以使用
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
             version="4.0"
             metadata-complete="true">
</web-app>
```

web.xml中 注册Servlet、Servlet的请求路径
```xml
  <!--注册Servlet-->
  <servlet>
    <servlet-name>***</servlet-name>
    <servlet-class>com.fly.servlet.类名</servlet-class>
  </servlet>
  <!--Servlet的请求路径-->
  <servlet-mapping>
    <servlet-name>***</servlet-name>
<!--    记住有斜杠-->
    <url-pattern>/***</url-pattern>
  </servlet-mapping>
  
  <!--    过滤器-->
   <filter>
     <filter-name>CharacterEncodingFilter</filter-name>
     <filter-class>com.fly.filter.CharacterEncodingFilter</filter-class>
   </filter>
   <filter-mapping>
     <filter-name>CharacterEncodingFilter</filter-name>
     <!--只要是 /servlet的任何请求，会经过这个过滤器-->
     <url-pattern>/servlet/*</url-pattern>
     <!--<url-pattern>/*</url-pattern>-->
   </filter-mapping>
```

编码问题
```servlet
req.setCharacterEncoding("UTF-8");
resp.setCharacterEncoding("UTF-8");
resp.setContentType("text/html;charset=utf-8");
```

```servlet
resp.setContentType("text/html");
resp.setCharacterEncoding("utf-8");
PrintWriter writer = resp.getWriter();
writer.print("<h1>404</h1>");
```

pom.xml
 ```xml
  <build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes> <!--确保resource目录下的properties和xml可以导出-->
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes> <!--确保java目录下的properties和xml可以导出-->
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>

<!--项目依赖-->
<dependencies>
    <!--具体依赖的jar包配置文件-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
<!--            <scope>test</scope>-->
    </dependency>

    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<!--        servlet依赖-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
<!--        jsp-->
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>javax.servlet.jsp-api</artifactId>
        <version>2.3.3</version>
    </dependency>

<!--        JSTL表达式的依赖-->
    <dependency>
        <groupId>javax.servlet.jsp.jstl</groupId>
        <artifactId>jstl-api</artifactId>
        <version>1.2</version>
    </dependency>
<!--        standard标签库-->
    <dependency>
        <groupId>taglibs</groupId>
        <artifactId>standard</artifactId>
        <version>1.1.2</version>
    </dependency>
    
    
<!--自定义依赖    -->
    <dependency>
        <groupId>rxtxcomm</groupId>  <!-- 库名称，也可以自定义 -->
        <artifactId>rxtxcomm</artifactId>    <!--库名称，也可以自定义-->
        <version>2.1.7</version> <!--版本号-->
        <scope>system</scope> <!--作用域-->
        <systemPath>/Users/andrew/.m2/repository/FromWeb/rxtx-2.1-7-bins-r2/RXTXcomm.jar
        </systemPath> <!--项目根目录下的lib文件夹下-->
    </dependency>

</dependencies>

```


