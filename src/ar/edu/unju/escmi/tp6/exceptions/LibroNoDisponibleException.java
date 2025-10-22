package ar.edu.unju.escmi.tp6.exceptions;

/* Hereda de Exception para que sea una checked exception */
public class LibroNoDisponibleException extends Exception{
    
    /* Constructor por defecto, proporciona un mensaje estándar */
    public LibroNoDisponibleException() {
        super("El libro no está disponible para ser prestado");
    }

    /* Constructor que permite pasar un mensaje personalizado al lanzar la excepción */
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
