package com.mycompany.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HabitacionDAO implements CRUD<Habitacion> {

    private static HabitacionDAO instance;
    private Connection connection;

    private HabitacionDAO() {
        connection = MySqlConnection.getConnection();
    }

    public static synchronized HabitacionDAO getInstance() {
        if (instance == null) {
            instance = new HabitacionDAO();
        }
        return instance;
    }

    @Override
    public void create(Habitacion habitacion, Storage storage) {
        try {
            String query = "INSERT INTO Habitaciones (nombre_habitacion, descripcion, direccion, ciudad, precio, disponible, id_propietario, id_estado_habitacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, habitacion.getNombreHabitacion());
            statement.setString(2, habitacion.getDescripcion());
            statement.setString(3, habitacion.getDireccion());
            statement.setString(4, habitacion.getCiudad());
            statement.setDouble(5, habitacion.getPrecio());
            statement.setBoolean(6, habitacion.isDisponible());
            statement.setInt(7, habitacion.getIdPropietario());
            statement.setInt(8, habitacion.getIdEstadoHabitacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Habitacion read(int id) {
        try {
            String query = "SELECT * FROM Habitaciones WHERE id_habitacion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNombreHabitacion(resultSet.getString("nombre_habitacion"));
                habitacion.setDescripcion(resultSet.getString("descripcion"));
                habitacion.setDireccion(resultSet.getString("direccion"));
                habitacion.setCiudad(resultSet.getString("ciudad"));
                habitacion.setPrecio(resultSet.getDouble("precio"));
                habitacion.setDisponible(resultSet.getBoolean("disponible"));
                habitacion.setIdPropietario(resultSet.getInt("id_propietario"));
                habitacion.setIdEstadoHabitacion(resultSet.getInt("id_estado_habitacion"));
                return habitacion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Habitacion habitacion) {
        try {
            String query = "UPDATE Habitaciones SET nombre_habitacion = ?, descripcion = ?, direccion = ?, ciudad = ?, precio = ?, disponible = ?, id_propietario = ?, id_estado_habitacion = ? WHERE id_habitacion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, habitacion.getNombreHabitacion());
            statement.setString(2, habitacion.getDescripcion());
            statement.setString(3, habitacion.getDireccion());
            statement.setString(4, habitacion.getCiudad());
            statement.setDouble(5, habitacion.getPrecio());
            statement.setBoolean(6, habitacion.isDisponible());
            statement.setInt(7, habitacion.getIdPropietario());
            statement.setInt(8, habitacion.getIdEstadoHabitacion());
            statement.setInt(9, habitacion.getIdHabitacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM Habitaciones WHERE id_habitacion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void create(Habitacion nuevaHabitacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
