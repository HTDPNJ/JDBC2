package com.hfut.test;

import com.hfut.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="select * from dept";
        //5 指定sql命令
        ResultSet rs=stmt.executeQuery(sql);
        List<Dept>list=new ArrayList<>();
        while(rs.next()){
            Dept dept=new Dept();
            dept.setDeptno(rs.getInt("deptno"));
            dept.setDname(rs.getString("dname"));
            dept.setDname(rs.getString("dname"));
            list.add(dept);
        }
        //关闭资源
        stmt.close();
        conn.close();
        for(Dept tem:list){
            System.out.println(tem.toString());
        }
    }
}
