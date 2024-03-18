/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

/**
 *
 * @author allib
 */
public class Habitacion {
 
        private int idHabitacion;
        private String nombreHabitacion;
        private String descripcion;
        private String direccion;
        private String ciudad;
        private double precio;
        private boolean disponible;
        private int idPropietario;
        private int idEstadoHabitacion;

        public Habitacion(int idHabitacion, String nombreHabitacion, String descripcion,
                String direccion, String ciudad, double precio, boolean disponible,
                int idPropietario, int idEstadoHabitacion) {
            this.idHabitacion = idHabitacion;
            this.nombreHabitacion = nombreHabitacion;
            this.descripcion = descripcion;
            this.direccion = direccion;
            this.ciudad = ciudad;
            this.precio = precio;
            this.disponible = disponible;
            this.idPropietario = idPropietario;
            this.idEstadoHabitacion = idEstadoHabitacion;
        }

    Habitacion(String nombre, String descripcion, String direccion, String ciudad, double precio, boolean disponible, int idPropietario, int idEstadoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.precio = precio;
        this.disponible = disponible;
        this.idPropietario = idPropietario;
        this.idEstadoHabitacion = idEstadoHabitacion;
    }

    Habitacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public int getIdEstadoHabitacion() {
        return idEstadoHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public void setIdEstadoHabitacion(int idEstadoHabitacion) {
        this.idEstadoHabitacion = idEstadoHabitacion;
    }

       
        @Override
        public String toString() {
            return "Habitacion{"
                    + "idHabitacion=" + idHabitacion
                    + ", nombreHabitacion='" + nombreHabitacion + '\''
                    + ", descripcion='" + descripcion + '\''
                    + ", direccion='" + direccion + '\''
                    + ", ciudad='" + ciudad + '\''
                    + ", precio=" + precio
                    + ", disponible=" + disponible
                    + ", idPropietario=" + idPropietario
                    + ", idEstadoHabitacion=" + idEstadoHabitacion
                    + '}';
        }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setNombre(String nuevoNombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

   
