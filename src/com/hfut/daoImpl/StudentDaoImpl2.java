package com.hfut.daoImpl;

import com.hfut.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl2 {

    public int insDept(int deptno,String dname,String loc) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="insert into dept values('"+deptno+"','"+dname+"','"+loc+"') ";
        //5 指定sql命令
        int i=stmt.executeUpdate(sql);

        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }

    public int delDept(int deptno) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="delete from dept where deptno='"+deptno+"'";
        //5 指定sql命令
        int i=stmt.executeUpdate(sql);

        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }

    public int upDept(int deptno,String newDname) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="update dept set dname='"+newDname+"' where deptno='"+deptno+"'";
        //5 指定sql命令
        int i=stmt.executeUpdate(sql);

        //关闭资源
        stmt.close();
        conn.close();
        return i;
    }

}
