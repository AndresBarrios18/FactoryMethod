/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author pipe2
 */
public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/method";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private MySqlConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new MySqlConnection();
        }
        return connection;
    }
}
