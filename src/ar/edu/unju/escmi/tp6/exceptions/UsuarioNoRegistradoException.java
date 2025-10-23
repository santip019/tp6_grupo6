package ar.edu.unju.escmi.tp6.exceptions;

/* Exception es de tipo unchaked por runtime exception*/
public class UsuarioNoRegistradoException extends RuntimeException{
    
    /* Constructor por defecto, proporciona un mensaje estándar */
    public UsuarioNoRegistradoException() {
        super("El usuario no está registrado");
    }

    /* Constructor que permite pasar un mensaje personalizado al lanzar la excepción */
    public UsuarioNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
