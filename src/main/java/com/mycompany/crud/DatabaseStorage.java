package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseStorage implements Storage {
    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveUser(Universidad universidad) {
    try {
        String query = "INSERT INTO universidades (id_universidad, nombre_universidad, direccion, ciudad) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, universidad.getIdUniversidad());
        statement.setString(2, universidad.getNombreUniversidad());
        statement.setString(3, universidad.getDireccion());
        statement.setString(4, universidad.getCiudad());
        statement.executeUpdate();
        System.out.println("Usuario guardado en la base de datos.");
    } catch (SQLException e) {
        System.out.println("Error al guardar usuario en la base de datos: " + e.getMessage());
    }
}
}