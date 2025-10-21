package ar.edu.unju.escmi.tp6.dominio;

public class Libro {
    private int id;
    private String autor;
    private String titulo;
    private String isbn;
    private boolean estado;

    /* Constructor por defecto */
    public Libro() {
    }

    /* Constructor parametrizado */
    public Libro(int id, String autor, String titulo, String isbn, boolean estado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.estado = estado;
    }

    /* Getters y Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /* Métodos */
    public void mostrarDatos() {
        System.out.println("ID libro: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.print("Estado: ");
        if (estado) {
            System.out.println("DISPONIBLE");
        }
        else {
            System.out.println("NO DISPONIBLE");
        }
    }
}
