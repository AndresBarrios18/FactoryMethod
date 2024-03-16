/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author pipe2
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la acción a realizar:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Leer usuario");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");

        int action = scanner.nextInt();
        UserDAO userDAO = UserDAO.getInstance();

        switch (action) {
            case 1: // Crear usuario
                createUser(userDAO);
                break;
            case 2: // Leer usuario
                readUser(userDAO);
                break;
            case 3: // Actualizar usuario
                updateUser(userDAO);
                break;
            case 4: // Eliminar usuario
                deleteUser(userDAO);
                break;
            default:
                System.out.println("Acción no válida.");
        }
    }

    private static void createUser(UserDAO userDAO) {
      Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario:");
        int id = scanner.nextInt();
        System.out.println("Ingrese el nombre del usuario:");
        String name = scanner.next();

        User newUser = new User(id, name);
        userDAO.create(newUser);
        System.out.println("Usuario creado exitosamente.");
    }

    private static void readUser(UserDAO userDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario a leer:");
        int id = scanner.nextInt();

        User retrievedUser = userDAO.read(id);
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getName());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void updateUser(UserDAO userDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario a actualizar:");
        int id = scanner.nextInt();
        System.out.println("Ingrese el nuevo nombre del usuario:");
        String newName = scanner.next();

        User retrievedUser = userDAO.read(id);
        if (retrievedUser != null) {
            retrievedUser.setName(newName);
            userDAO.update(retrievedUser);
            System.out.println("Usuario actualizado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void deleteUser(UserDAO userDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario a eliminar:");
        int id = scanner.nextInt();

        userDAO.delete(id);
        System.out.println("Usuario eliminado exitosamente.");
    }
}
