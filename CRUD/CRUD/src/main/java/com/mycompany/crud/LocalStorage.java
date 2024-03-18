/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pipe2
 */

public class LocalStorage implements Storage {
    @Override
    public void saveUser(User user) {
        String filePath = "C:\\Users\\pipe2\\Desktop\\Prueba\\usuarios.txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(user.getId() + "," + user.getName() + "\n");
            writer.close();
            System.out.println("Usuario guardado localmente en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar usuario localmente: " + e.getMessage());
        }
    }
}
