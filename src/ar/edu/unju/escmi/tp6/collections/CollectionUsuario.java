package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;
import ar.edu.unju.escmi.tp6.dominio.Usuario;

public class CollectionUsuario {
    public static Map<Integer, Usuario> usuarios = new HashMap<>();

    public static void guardarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public static Usuario buscarUsuario(int id) {
        return usuarios.get(id);
    }

    public static void mostrarUsuarios() {
        for (Usuario u : usuarios.values()) {
            u.mostrarDatos();
            System.out.println("-------------------");
        }
    }

    public static void encontrarUsuario(int id) {

        try {

            Usuario usuarioEncontrado = CollectionUsuario.buscarUsuario(id); // ya lanza la excepción si no existe
            System.out.println("Usuario encontrado:");
            usuarioEncontrado.mostrarDatos();

        } catch (UsuarioNoRegistradoException e) { // Captura la excepción personalizada
            System.out.println(e.getMessage()); // Manejo de la excepción
        }

    }

}
