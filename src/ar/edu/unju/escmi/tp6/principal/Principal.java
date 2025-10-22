package ar.edu.unju.escmi.tp6.principal;

import java.util.Scanner;

import ar.edu.unju.escmi.tp6.collections.CollectionLibro;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte op;

        do {

            System.out.println("\n **** Menu de Opciones ****");
            System.out.println("1 - Registrar Libro");
            System.out.println("2 - Registrar Usuario");
            System.out.println("3 - Prestamo de Libro");
            System.out.println("4 - Devolucion de Libro");
            System.out.println("5 - Listar Libros");
            System.out.println("6 - Listar Usuarios");
            System.out.println("7 - Salir");
            System.out.print("Ingrese una opcion: ");
            op = scanner.nextByte();
            scanner.nextLine(); // Para limpiar el buffer del scanner

            switch (op) {
                case 1:
                    // La opción 1 permite agregar un libro nuevo a la biblioteca.
                    break;
                case 2:
                    // La opción 2 permite registrar un nuevo usuario (alumno o bibliotecario).
                    break;
                case 3:
                    // La opción 3 permite registrar un préstamo de un libro, se debe verificar que
                    // el libro esté disponible.
                    System.out.println("Ingrese el id del libro a prestar: ");
                    int libroId = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    CollectionLibro.libroDisponible(libroId);
                    break;
                case 4:
                    // La opción 4 permite actualizar la disponibilidad del libro. En el registro de
                    // préstamo se debe ingresar la fecha de devolución.
                    break;
                case 5:
                    // La opción 5 permite mostrar los libros con los que cuenta la biblioteca, se
                    // debe mostrar la información del libro y el estado.
                    break;
                case 6:
                    // La opción 6 permite mostrar los usuarios con los que cuenta el sistema, se
                    // deben mostrar los datos de cada usuario registrado.
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // aqui podria ir un try-catch
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }

        } while (op != 7);

        scanner.close();
    }

}
