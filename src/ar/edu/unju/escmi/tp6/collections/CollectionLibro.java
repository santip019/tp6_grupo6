package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

public class CollectionLibro {

    public static Map<Integer, Libro> libros = new HashMap<>();

    public static void guardarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }

    public static Libro buscarLibro(int id) throws ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException {
        Libro l = libros.get(id);
        if (l == null) {
            throw new LibroNoEncontradoException("Libro con id " + id + " no encontrado");
        }
        return l;
    }
    
    /**
     * Precarga de libros de ejemplo para evitar tener que ingresarlos manualmente
     * al iniciar la aplicación.
     */
    public static void precargarLibros() {
        guardarLibro(new Libro(1, "Gabriel García Márquez", "Cien años de soledad", "978-84-376-0494-7", true));
        guardarLibro(new Libro(2, "J.K. Rowling", "Harry Potter y la piedra filosofal", "978-84-7888-588-7", true));
        guardarLibro(new Libro(3, "George Orwell", "1984", "978-84-670-1888-5", true));
        guardarLibro(new Libro(4, "J.R.R. Tolkien", "El señor de los anillos", "978-84-450-0001-1", true));
        guardarLibro(new Libro(5, "Mario Vargas Llosa", "La ciudad y los perros", "978-84-206-0003-3", true));
    }

    public static void mostrarLibros() {

        for (Libro l : libros.values()) {
            l.mostrarDatos();
            System.out.println("-------------------");
        }
    }

    public static void libroDisponible(int id) {
        try {
            Libro libroPrestamo = CollectionLibro.buscarLibro(id);

            // Si el libro existe pero no está disponible
            if (!libroPrestamo.isEstado()) {
                throw new LibroNoDisponibleException();
            }

            // Si pasa las verificaciones, se marca como prestado
            libroPrestamo.setEstado(false);
            System.out.println("El libro '" + libroPrestamo.getTitulo() + "' ha sido prestado exitosamente.");

        } catch (LibroNoEncontradoException | LibroNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
