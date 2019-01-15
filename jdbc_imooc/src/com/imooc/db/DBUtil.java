/**
 * Copyright (C)，2019-2019,Infor
 * Author: lli3
 * Description Test DBUtil
 */

package com.imooc.db;

import java.sql.*;

public class DBUtil {
//    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc";
//    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&characterEncoding=utf8";
    private static final String USER="root";
    private static final String PASSWORD="password";

    private static Connection conn=null;

    static {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            conn=DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

   /* public static void main(String[] args) throws Exception{
        Connection conn=DBUtil.getConnection();
        Statement stmt =conn.createStatement();
        ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");

        while (rs.next()) {
            System.out.println(rs.getString("user_name") +"," +rs.getInt("age"));
        }

    }*/
}
