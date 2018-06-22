package com.walle.test;

import java.sql.*;

public class TestJDbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://119.29.115.175:3306/girl?useUnicode=true&characterEncoding=utf8&useSSL=true&verifyServerCertificate=false","root","1234!@#$qwerQWER");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.166:3306/example?useUnicode=true&characterEncoding=utf8","root","123456");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from girl");
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }

    }
}
