package modelo;

import org.springframework.web.multipart.MultipartFile;

public class Libro {

    private String titulo;
    private Double precio;
    private String descripcion;
    private MultipartFile imagen;
    private long id;

    public Libro() {
    }

    public Libro(String titulo, Double precio, String descripcion, long id) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.id = id;
    }

    public Libro(String titulo, Double precio, String descripcion) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", id=" + id +
                '}';
    }
}
