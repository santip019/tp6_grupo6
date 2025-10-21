package ar.edu.unju.escmi.tp6.dominio;

public class Bibliotecario extends Usuario {
    private int legajo;

    /* Constructor por defecto */
    public Bibliotecario() {
    }

    /* Constrcutor parametrizado */
    public Bibliotecario(int id, String nombre, String apellido, String email, int legajo) {
        super(id, nombre, apellido, email);
        this.legajo = legajo;
    }
    
    /* Getter y Setter */
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    /* Método */
    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Bibliotecario: " + nombre + " " + apellido);
        System.out.println("Legajo: " + legajo);
        System.out.println("Email: " + email);
    }
    

}
