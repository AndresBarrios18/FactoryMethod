/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pipe2
 */
public class DatabaseStorage implements Storage {
    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveUser(User user) {
    try {
        String query = "INSERT INTO users (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.executeUpdate();
        System.out.println("Usuario guardado en la base de datos.");
    } catch (SQLException e) {
        System.out.println("Error al guardar usuario en la base de datos: " + e.getMessage());
    }
}
}