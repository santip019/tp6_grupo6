package ar.edu.unju.escmi.tp6.exceptions;

/* Hereda de Exception para que sea una checked exception */
public class LibroNoEncontradoException extends Exception{
    
    /* Constructor por defecto, proporciona un mensaje estándar */
    public LibroNoEncontradoException() {
        super("El libro no se encuentra en la biblioteca");
    }

    /* Constructor que permite pasar un mensaje personalizado al lanzar la excepción */
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
