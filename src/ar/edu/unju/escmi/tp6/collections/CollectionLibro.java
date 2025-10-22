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

    public static Libro buscarLibro(int id) {
        return libros.get(id);
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

            // Si el libro no existe, lanzamos la excepción personalizada
            if (libroPrestamo == null) {
                throw new LibroNoEncontradoException();
            }

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
