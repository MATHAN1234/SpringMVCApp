package com.pro.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyDb {
    public Connection con;
    public Connection getCon() throws ClassNotFoundException, SQLException {
//        String url="jdbc:mysql://localhost:3307/myusers?autoReconnect=true&useSSL=false";
//        String user="root";
//        String password="";
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/myusers?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "toor123");
        return con;
    }
}
