package modelo;

public class Libro {

    private String titulo;
    private Double precio;
    private String descripcion;
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
