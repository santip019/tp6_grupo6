package ar.edu.unju.escmi.tp6.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaUtil {

    public static LocalDate convertirStringLocalDate(String fechaStr) throws ParseException { // Método para
                                                                                              // convertirString a
                                                                                              // LocalDate, se usa el
                                                                                              // throws ParseException
                                                                                              // para que se propague la
                                                                                              // excepción al método
                                                                                              // invocador

        // Definimos el formato esperado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // DatatimeFormatter es una clase que
                                                                                 // permite definir formatos de fecha y
                                                                                 // hora que luego se usan para parsear
                                                                                 // o formatear fechas y que esta en el
                                                                                 // paquete java.time.format

        try {
            // Intentamos parsear el String a LocalDate
            return LocalDate.parse(fechaStr, formatter);

        } catch (DateTimeParseException e) {
            // Si falla el parseo, lanzamos una ParseException que se propaga al método
            // invocador
            throw new ParseException("Fecha inválida: " + fechaStr + ". Debe ser dd/MM/yyyy", 0); // El 0 indica la
                                                                                                  // posición en la
                                                                                                  // cadena donde
                                                                                                  // ocurrió el error
        }

    }
}
