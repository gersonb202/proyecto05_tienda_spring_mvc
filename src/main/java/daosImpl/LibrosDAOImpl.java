package daosImpl;

import daos.LibrosDAO;
import modelo.Libro;

import java.util.Collections;
import java.util.List;

public class LibrosDAOImpl implements LibrosDAO {

    @Override
    public void registrarLibro(Libro libro) {
        System.out.println("resgistrar nuevo libro = " + libro);
    }

    @Override
    public List<Libro> obtenerLibros() {
        return Collections.emptyList();
    }

    @Override
    public void borrarLibro(long id) {

    }

    @Override
    public void actualizarLibro(Libro libro) {

    }
}
