package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp6.dominio.Libro;

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
}
