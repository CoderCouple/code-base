package com.javaarchaius.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static String driver, url, username, password;
    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/yplay?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        username = "root";
        password = "Sunil@28";
    }

    private JDBCUtil(){}

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }

}

