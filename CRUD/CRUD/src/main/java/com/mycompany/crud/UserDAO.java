/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author pipe2
 */
public class UserDAO implements CRUD<User> {

    private static UserDAO instance;
    private Connection connection;

    private UserDAO() {
        // Aquí deberías inicializar la conexión a la base de datos
        // Esto es solo un ejemplo, deberías proporcionar tus propios detalles de conexión
        connection = MySqlConnection.getConnection();
    }

    public static synchronized UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public void create(User user, Storage storage) {
        
        if (storage == null) {
            System.out.println("No se proporcionó un objeto Storage válido.");
            return;
        }
        
       
        storage.saveUser(user);
    }

    @Override
    public User read(int id) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try {
            String query = "UPDATE users SET name=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}