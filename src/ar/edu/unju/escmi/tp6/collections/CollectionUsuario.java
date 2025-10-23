package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;

public class CollectionUsuario {
    public static Map<Integer, Usuario> usuarios = new HashMap<>();

    public static void guardarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public static Usuario buscarUsuario(int id) throws ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException {
        Usuario usuario = usuarios.get(id);
        if (usuario == null) {
        throw new UsuarioNoRegistradoException("No existe un usuario con ID: " + id);
    }
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

    } catch (UsuarioNoRegistradoException e) {
        System.out.println(e.getMessage());
    }
}

    /**
     * Precarga de usuarios de ejemplo: 3 alumnos y 2 bibliotecarios.
     */
    public static void precargarUsuarios() {
        // Alumnos
        guardarUsuario(new ar.edu.unju.escmi.tp6.dominio.Alumno(101, "Ana", "Gomez", "ana.gomez@example.com", "A101", "1A"));
        guardarUsuario(new ar.edu.unju.escmi.tp6.dominio.Alumno(102, "Luis", "Perez", "luis.perez@example.com", "A102", "2B"));
        guardarUsuario(new ar.edu.unju.escmi.tp6.dominio.Alumno(103, "María", "Lopez", "maria.lopez@example.com", "A103", "3C"));
        // Bibliotecarios
        guardarUsuario(new ar.edu.unju.escmi.tp6.dominio.Bibliotecario(201, "Carlos", "Sanchez", "carlos.sanchez@example.com", 5001));
        guardarUsuario(new ar.edu.unju.escmi.tp6.dominio.Bibliotecario(202, "Lucía", "Martinez", "lucia.martinez@example.com", 5002));
    }
}
