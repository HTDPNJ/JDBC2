package com.hfut.daoImpl;

import com.hfut.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentdaoImpl {
    public List<Dept>getDeptInfo() throws ClassNotFoundException, SQLException {
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="select * from dept ";
        //5 指定sql命令
        ResultSet rs=stmt.executeQuery(sql);
        List<Dept> list=new ArrayList<>();
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
        return list;
    }
    public int updateSname(String newName) throws SQLException, ClassNotFoundException {
        //创建Scanner对象
        //1、加载驱动类
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2、获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        //设置事务手动提交
        conn.setAutoCommit(false);
        //3 获取sql命令对象
        Statement stmt=conn.createStatement();
        //4 创建sql命令
        String sql="update dept set dname ='"+newName+ " ' where deptno=60";
        //5 指定sql命令
        try{
            int i=stmt.executeUpdate(sql);
            conn.commit();
            return i;
        }catch(Exception e){
            conn.rollback();
        }
        //关闭资源
        stmt.close();
        conn.close();
        return -1;
    }
}
