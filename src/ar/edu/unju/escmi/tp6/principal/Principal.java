package ar.edu.unju.escmi.tp6.principal;

import java.util.Scanner;
import java.time.LocalDate;

import ar.edu.unju.escmi.tp6.collections.CollectionLibro;
import ar.edu.unju.escmi.tp6.collections.CollectionUsuario;
import ar.edu.unju.escmi.tp6.collections.CollectionPrestamo;
import ar.edu.unju.escmi.tp6.dominio.Alumno;
import ar.edu.unju.escmi.tp6.dominio.Bibliotecario;
import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;


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
                    System.out.println("Registrar Libro");
                    System.out.print("Ingrese ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer

                    System.out.print("Ingrese autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ingrese título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese ISBN: ");
                    String isbn = scanner.nextLine();
                    // se crea el nuevo libro
                    Libro libro = new Libro(idLibro, autor, titulo, isbn, true);
                    CollectionLibro.guardarLibro(libro);
                    System.out.println("Libro registrado correctamente.");
                    break;

                case 2:
                //La opción 2 permite registrar un nuevo usuario (alumno o bibliotecario).
                    System.out.println("\n**** Registro de Usuario ****");
                    System.out.println("1 - Registrar Alumno");
                    System.out.println("2 - Registrar Bibliotecario");
                    System.out.print("Seleccione tipo de usuario: ");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoUsuario) {
                        case 1: // Alumno
                            System.out.print("ID: ");
                            int idAlumno = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                // Verificar si el usuario ya existe usando el mismo procedimiento
                                CollectionUsuario.buscarUsuario(idAlumno);
                                System.out.println("Ya existe un usuario con ese ID. No se puede registrar nuevamente.");
                                break; // salir del método, con la posibilidad de volver a ingresar otro id
                            } catch (UsuarioNoRegistradoException e) {
                                // Si entra al catch, significa que NO existe el usuario
                                System.out.println("El ID está disponible. Puede continuar con el registro.");
                            }
                            System.out.print("Nombre: ");
                            String nombreAlumno = scanner.nextLine();
                            System.out.print("Apellido: ");
                            String apellidoAlumno = scanner.nextLine();
                            System.out.print("Email: ");
                            String emailAlumno = scanner.nextLine();
                            System.out.print("N° de libreta: ");
                            String nroLibreta = scanner.nextLine();
                            System.out.print("Curso: ");
                            String curso = scanner.nextLine();

                            Alumno alumno = new Alumno(idAlumno, nombreAlumno, apellidoAlumno, emailAlumno, nroLibreta, curso);
                            CollectionUsuario.guardarUsuario(alumno);
                            System.out.println("Alumno registrado correctamente.");
                            break;
                        case 2: // Bibliotecario
                            System.out.print("ID: ");
                            int idBibliotecario = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                // Verificar si el usuario ya existe usando el mismo procedimiento
                                CollectionUsuario.buscarUsuario(idBibliotecario);
                                System.out.println("Ya existe un usuario con ese ID. No se puede registrar nuevamente.");
                                return; // salir del método para evitar continuar con el registro
                            } catch (UsuarioNoRegistradoException e) {
                                // Si entra al catch, significa que NO existe el usuario
                                System.out.println("El ID está disponible. Puede continuar con el registro.");
                            }
                            System.out.print("Nombre: ");
                            String nombreBiblio = scanner.nextLine();
                            System.out.print("Apellido: ");
                            String apellidoBiblio = scanner.nextLine();
                            System.out.print("Email: ");
                            String emailBiblio = scanner.nextLine();
                            System.out.print("Legajo: ");
                            int legajo = scanner.nextInt();

                            Bibliotecario bibliotecario = new Bibliotecario(idBibliotecario, nombreBiblio, apellidoBiblio, emailBiblio, legajo);
                            CollectionUsuario.guardarUsuario(bibliotecario);
                            System.out.println("Bibliotecario registrado correctamente.");
                            break;

                        default:
                            System.out.println("Tipo de usuario inválido. Intente nuevamente.");
                    }
                    break;
                case 3:
                //La opción 3 permite registrar un préstamo de un libro, se debe verificar que el libro esté disponible.
                    System.out.println("Prestamo de Libro");
                    try {
                        System.out.print("ID del usuario: ");
                        int idUsuarioPrestamo = scanner.nextInt();
                        scanner.nextLine();
                        // Buscar usuario
                        Usuario usuarioPrestamo = CollectionUsuario.buscarUsuario(idUsuarioPrestamo);
                        if (usuarioPrestamo == null) {
                            throw new UsuarioNoRegistradoException();
                        }
                        System.out.println("Ingrese el id del libro a prestar: ");
                        int libroId = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        // Verificar disponibilidad del libro (lanza excepciones si hay problema)
                        CollectionLibro.libroDisponible(libroId);
                        System.out.print("Ingrese el ID del prestamo: ");
                        int idPrestamo = scanner.nextInt();
                        scanner.nextLine();
                        // Buscar libro para crear el prestamo
                        Libro libroPrestamo = CollectionLibro.buscarLibro(libroId);

                        System.out.print("Ingrese fecha de préstamo (dd/MM/yyyy): ");
                        String fechaPrestamoStr = scanner.nextLine();
                        LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaPrestamoStr);
                        // Crear y guardar préstamo
                        Prestamo prestamo = new Prestamo(usuarioPrestamo, libroPrestamo, idPrestamo, fechaPrestamo, null);
                        CollectionPrestamo.guardarPrestamo(prestamo);
                        
                        System.out.println("Préstamo registrado con éxito.");

                        } catch (UsuarioNoRegistradoException e) {
                            System.out.println(" Error: " + e.getMessage());
                        } catch (Exception e) {
                            // Captura LibroNoDisponibleException, LibroNoEncontradoException o errores de fecha
                            System.out.println(" Error durante el préstamo: " + e.getMessage());
                        }
                        break;
                case 4:
                //La opción 4 permite actualizar la disponibilidad del libro. En el registro de préstamo se debe ingresar la fecha de devolución.
                    System.out.println("Devolucion de Libro");
                     try {
                        System.out.print("Ingrese el ID del prestamo: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer
                        Prestamo prestamo = CollectionPrestamo.buscarPrestamo(id);

                        if (prestamo == null) {
                            throw new LibroNoEncontradoException("No se encontró un préstamo con ese ID.");
                        }
                        if (prestamo.getFechaDevolucion() != null) {
                            System.out.println("El libro ya fue devuelto el " + prestamo.getFechaDevolucion());
                        } else {
                            prestamo.registrarDevolucion(LocalDate.now());
                            System.out.println("Devolución registrada correctamente para el libro: " + prestamo.getLibro().getTitulo());
                        }
                    } catch (LibroNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }
                    break;
                case 5:
                // La opción 5 permite mostrar los libros con los que cuenta la biblioteca, se debe mostrar la información del libro y el estado.
                    System.out.println("\n **** Lista de libros ****");
                    CollectionLibro.mostrarLibros();
                    break;
                case 6:
                // La opción 6 permite mostrar los usuarios con los que cuenta el sistema, se deben mostrar los datos de cada usuario registrado.
                    System.out.println("\n **** Lista de usuarios ****");
                    CollectionUsuario.mostrarUsuarios();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                //aqui podria ir un try-catch
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }

        } while (op != 7);

        scanner.close();
    }
}