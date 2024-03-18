package com.mycompany.crud;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la acción a realizar:");
        System.out.println("1. Crear habitación");
        System.out.println("2. Leer habitación");
        System.out.println("3. Actualizar habitación");
        System.out.println("4. Eliminar habitación");

        int action = scanner.nextInt();
        HabitacionDAO habitacionDAO = HabitacionDAO.getInstance();

        switch (action) {
            case 1: // Crear habitación
                createHabitacion(habitacionDAO);
                break;
            case 2: // Leer habitación
                readHabitacion(habitacionDAO);
                break;
            case 3: // Actualizar habitación
                updateHabitacion(habitacionDAO);
                break;
            case 4: // Eliminar habitación
                deleteHabitacion(habitacionDAO);
                break;
            default:
                System.out.println("Acción no válida.");
        }
    }

    private static void createHabitacion(HabitacionDAO habitacionDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la habitación:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la descripción de la habitación:");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese la dirección de la habitación:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese la ciudad de la habitación:");
        String ciudad = scanner.nextLine();
        System.out.println("Ingrese el precio de la habitación:");
        double precio = scanner.nextDouble();
        System.out.println("La habitación está disponible? (true/false):");
        boolean disponible = scanner.nextBoolean();
        System.out.println("Ingrese el ID del propietario de la habitación:");
        int idPropietario = scanner.nextInt();
        System.out.println("Ingrese el ID del estado de la habitación:");
        int idEstadoHabitacion = scanner.nextInt();

        Habitacion nuevaHabitacion = new Habitacion(nombre, descripcion, direccion, ciudad, precio, disponible, idPropietario, idEstadoHabitacion);
        habitacionDAO.create(nuevaHabitacion);
        System.out.println("Habitación creada exitosamente.");
    }

    private static void readHabitacion(HabitacionDAO habitacionDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la habitación a leer:");
        int id = scanner.nextInt();

        Habitacion habitacion = habitacionDAO.read(id);
        if (habitacion != null) {
            System.out.println("Nombre de la habitación: " + habitacion.getNombre());
           
        } else {
            System.out.println("Habitación no encontrada.");
        }
    }

    private static void updateHabitacion(HabitacionDAO habitacionDAO) {
   
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la habitación a actualizar:");
        int id = scanner.nextInt();

        // Leer la habitación actual para verificar si existe
        Habitacion habitacion = habitacionDAO.read(id);
        if (habitacion != null) {
            // Solicitar al usuario los nuevos valores de los atributos de la habitación
            System.out.println("Ingrese el nuevo nombre de la habitación:");
            String nuevoNombre = scanner.next();
            System.out.println("Ingrese la nueva descripción de la habitación:");
            String nuevaDescripcion = scanner.next();
            System.out.println("Ingrese la nueva dirección de la habitación:");
            String nuevaDireccion = scanner.next();
            System.out.println("Ingrese la nueva ciudad de la habitación:");
            String nuevaCiudad = scanner.next();
            System.out.println("Ingrese el nuevo precio de la habitación:");
            double nuevoPrecio = scanner.nextDouble();
            System.out.println("La habitación está disponible? (true/false):");
            boolean nuevaDisponibilidad = scanner.nextBoolean();
            System.out.println("Ingrese el nuevo ID del propietario de la habitación:");
            int nuevoIdPropietario = scanner.nextInt();
            System.out.println("Ingrese el nuevo ID del estado de la habitación:");
            int nuevoIdEstadoHabitacion = scanner.nextInt();

            // Actualizar los atributos de la habitación
            habitacion.setNombre(nuevoNombre);
            habitacion.setDescripcion(nuevaDescripcion);
            habitacion.setDireccion(nuevaDireccion);
            habitacion.setCiudad(nuevaCiudad);
            habitacion.setPrecio(nuevoPrecio);
            habitacion.setDisponible(nuevaDisponibilidad);
            habitacion.setIdPropietario(nuevoIdPropietario);
            habitacion.setIdEstadoHabitacion(nuevoIdEstadoHabitacion);

            // Llamar al método update de HabitacionDAO para actualizar la habitación en la base de datos
            habitacionDAO.update(habitacion);
            System.out.println("Habitación actualizada exitosamente.");
        } else {
            System.out.println("Habitación no encontrada.");
        }
    

    }

    private static void deleteHabitacion(HabitacionDAO habitacionDAO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la habitación a eliminar:");
        int id = scanner.nextInt();

        habitacionDAO.delete(id);
        System.out.println("Habitación eliminada exitosamente.");
    }
}
