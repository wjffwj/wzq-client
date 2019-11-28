package com.wzq.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @created by 24745
 * @date 2019/11/27
 */

public class ConnectionUtil {
    private static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wzq","root","wjffwj");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
