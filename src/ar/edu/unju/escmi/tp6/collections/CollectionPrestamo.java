package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;
import ar.edu.unju.escmi.tp6.dominio.Prestamo;

public class CollectionPrestamo {

    public static Map<Integer, Prestamo> prestamos = new HashMap<>();

    public static void guardarPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getId(), prestamo);
    }

    public static Prestamo buscarPrestamo(int id) {
        return prestamos.get(id);
    }

    public static void mostrarPrestamos() {
        
        for (Prestamo p : prestamos.values()) {
            p.mostrarDatos();
            System.out.println("-------------------");
        }
        
    }
}
