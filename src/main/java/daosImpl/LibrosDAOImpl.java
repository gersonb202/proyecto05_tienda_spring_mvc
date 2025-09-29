package daosImpl;

import daos.LibrosDAO;
import modelo.Libro;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LibrosDAOImpl implements LibrosDAO {

    // Tenemos que enlazar el datasource, a este LibrosDAOImpl
    // Para conseguir usar aquí spring jdbc

    private DataSource dataSource;
    private SimpleJdbcInsert simpleInsert;

    // Cuando se asigne el datasource, voy a preparar el simpleInsert
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        // Instanciamos el simpleInsert y le metemos el datasource
        this.simpleInsert = new SimpleJdbcInsert(dataSource);
        this.simpleInsert.setTableName("libros");
    }

    @Override
    public void registrarLibro(Libro libro) {
        System.out.println("resgistrar nuevo libro = " + libro);
        HashMap<String, Object> valores =
                new HashMap<String, Object>();
        valores.put("titulo", libro.getTitulo());
        valores.put("precio", libro.getPrecio());
        valores.put("descripcion", libro.getDescripcion());
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
