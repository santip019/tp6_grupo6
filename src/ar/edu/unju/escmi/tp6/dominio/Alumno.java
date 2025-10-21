package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private String nroLibreta;
    private String curso;

    /* Constructor por defecto */
    public Alumno() {

    }

    /* Constructor parametrizado */
    public Alumno(int id, String nombre, String apellido, String email, String nroLibreta, String curso) {
        super(id, nombre, apellido, email);
        this.nroLibreta = nroLibreta;
        this.curso = curso;
    }
    
    /* Getter y Setters */
    public String getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(String nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    /* Métodos */
    @Override
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Alumno: " + nombre + " " + apellido);
        System.out.println("Nro de Libreta: " + nroLibreta);
        System.out.println("Curso: " + curso);
        System.out.println("Email: " + email);
    }

    
}