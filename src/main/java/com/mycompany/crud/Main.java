package com.mycompany.crud;

import java.sql.Connection;
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
        UniversidadDAO universidadDAO = UniversidadDAO.getInstance();

        switch (action) {
            case 1: // Crear usuario
                createUser(universidadDAO);
                break;
            case 2: // Leer usuario
                readUser(universidadDAO);
                break;
            case 3: // Actualizar usuario
                updateUser(universidadDAO);
                break;
            case 4: // Eliminar usuario
                deleteUser(universidadDAO);
                break;
            default:
                System.out.println("Acción no válida.");
        }
    }

    private static void createUser(UniversidadDAO universidadDAO) {
        Scanner scanner = new Scanner(System.in);

    System.out.println("Seleccione el método de almacenamiento:");
    System.out.println("L. Almacenamiento local");
    System.out.println("D. Almacenamiento en base de datos");

    char storageOption = scanner.next().charAt(0);
    Storage storage;

    switch (storageOption) {
        case 'L':
            storage = new LocalStorage();
            break;
        case 'D':
     
            Connection connection = MySqlConnection.getConnection();
            storage = new DatabaseStorage(connection);
            break;
        default:
            System.out.println("Opción de almacenamiento no válida.");
            return;
    }

    System.out.println("Ingrese el ID de la universidad:");
    int id = scanner.nextInt();
    System.out.println("Ingrese el nombre de la universidad:");
    String name = scanner.next();
    System.out.println("Ingrese el direccion de la universidad:");
    String direccion = scanner.next();
    System.out.println("Ingrese el ciudad de la universidad:");
    String ciudad = scanner.next();
    

    Universidad newUser = new Universidad(id, name, direccion, ciudad);
    universidadDAO.create(newUser, storage);
    System.out.println("Usuario creado exitosamente.");
    }

    private static void readUser(UniversidadDAO universidadDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la universidad a leer:");
        int id = scanner.nextInt();

        Universidad retrievedUser = universidadDAO.read(id);
        if (retrievedUser != null) {
            System.out.println("El nombre de la universidad es : " + retrievedUser.getNombreUniversidad());
        } else {
            System.out.println("Universidad no encontrado.");
        }
    }

    private static void updateUser(UniversidadDAO universidadDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la universidad a actualizar:");
        int id = scanner.nextInt();
        System.out.println("Ingrese el nuevo nombre de la universidad:");
        String newName = scanner.next();
        System.out.println("Ingrese el nuevo nombre de la universidad:");
        String newDireccion = scanner.next();
        System.out.println("Ingrese el nuevo nombre de la universidad:");
        String newCiudad = scanner.next();
        
        
        Universidad retrievedUser = universidadDAO.read(id);
        if (retrievedUser != null) {
            retrievedUser.setNombreUniversidad(newName);
            universidadDAO.update(retrievedUser);
            System.out.println("Usuario actualizado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void deleteUser(UniversidadDAO universidadDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del usuario a eliminar:");
        int id = scanner.nextInt();

        universidadDAO.delete(id);
        System.out.println("Usuario eliminado exitosamente.");
    }
}
