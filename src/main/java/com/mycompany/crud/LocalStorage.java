package com.mycompany.crud;


import java.io.FileWriter;
import java.io.IOException;


public class LocalStorage implements Storage {
    @Override
    public void saveUser(Universidad universidad) {
        String filePath = "C:\\Users\\ronca\\OneDrive\\Escritorio\\Construccion";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(universidad.getIdUniversidad()+ "," + universidad.getNombreUniversidad() + "," + universidad.getDireccion() + "," + universidad.getCiudad()+ "\n");
            writer.close();
            System.out.println("Usuario guardado localmente en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar usuario localmente: " + e.getMessage());
        }
    }
}