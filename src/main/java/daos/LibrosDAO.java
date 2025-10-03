package daos;

import modelo.Libro;

import java.util.List;

public interface LibrosDAO {

    void registrarLibro(Libro libro);
    List<Libro> obtenerLibros();
    void borrarLibro(long id);
    void actualizarLibro(Libro libro);

    Libro obtenerLibroId(long l);
}
