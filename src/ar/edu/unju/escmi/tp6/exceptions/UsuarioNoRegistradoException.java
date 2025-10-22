package ar.edu.unju.escmi.tp6.exceptions;

/* Hereda de Exception para que sea una checked exception */
public class UsuarioNoRegistradoException extends Exception{
    
    /* Constructor por defecto, proporciona un mensaje estándar */
    public UsuarioNoRegistradoException() {
        super("El usuario no está registrado");
    }

    /* Constructor que permite pasar un mensaje personalizado al lanzar la excepción */
    public UsuarioNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
