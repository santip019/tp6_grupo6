package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;

    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    
    /* Constructor por defecto */
    public Prestamo() {
    }

    /* Contrcutor parametrizado */
    public Prestamo(Usuario usuario, Libro libro, int id, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    /* Getters y Setters */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /* Métodos */
    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        libro.setEstado(true);
    }

    public void mostrarDatos() {
        System.out.println("ID del Préstamo: " + id);
        System.out.println("Fecha de Préstamo: " + fechaPrestamo);
        if (fechaDevolucion != null) {
            System.out.println("Fecha de Devolución: " + fechaDevolucion);
        } 
        else {
            System.out.println("El libro aún no ha sido devuelto.");
        }
        System.out.println("--- Datos del Usuario ---");
        usuario.mostrarDatos();
        System.out.println("");
        System.out.println("--- Datos del Libro ---");
        libro.mostrarDatos();
    }
    
    
}
