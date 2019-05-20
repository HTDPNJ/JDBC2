package com.hfut.pratice;

import com.hfut.daoImpl.StudentdaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateName {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //创建Scanner对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新的昵称");
        String name=sc.nextLine();
        StudentdaoImpl sd=new StudentdaoImpl();
        int i=sd.updateSname(name);
        System.out.println(i);
    }
}
