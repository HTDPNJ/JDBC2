package com.hfut.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="insert into dept values(50,'吃鸡学院','北京')";
        //5 指定sql命令
        int i=stmt.executeUpdate(sql);
        System.out.println("执行结果"+i);
        //关闭资源
        stmt.close();
        conn.close();
    }
}
