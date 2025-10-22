package ar.edu.unju.escmi.tp6.exceptions;

// Excepción personalizada para indicar que un usuario no está registrado en el sistema, es de tipo unchecked
public class UsuarioNoRegistradoException extends RuntimeException {

    /* Constructor por defecto, proporciona un mensaje estándar */
    public UsuarioNoRegistradoException() {
        super("El usuario no está registrado");
    }

    /*
     * Constructor que permite pasar un mensaje personalizado al lanzar la excepción
     */
    public UsuarioNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
