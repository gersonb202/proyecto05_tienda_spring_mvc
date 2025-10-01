package daosImpl;

import constantesSql.ConstantesSQL;
import daos.LibrosDAO;
import mappers.LibrosMapper;
import modelo.Libro;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private JdbcTemplate jdbcTemplate;

    // Cuando se asigne el datasource, voy a preparar el simpleInsert
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        // Instanciamos el simpleInsert y le metemos el datasource
        this.simpleInsert = new SimpleJdbcInsert(dataSource);
        this.simpleInsert.setTableName("libros");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void registrarLibro(Libro libro) {
        System.out.println("resgistrar nuevo libro = " + libro);
        HashMap<String, Object> valores =
                new HashMap<String, Object>();
        valores.put("titulo", libro.getTitulo());
        valores.put("precio", libro.getPrecio());
        valores.put("descripcion", libro.getDescripcion());

        // Ejecutar inseción
        this.simpleInsert.execute(valores);
    }

    @Override
    public List<Libro> obtenerLibros() {
        // Vamos a usar el mapper, par facilmente obtener los libros
        List<Libro> libros = this.jdbcTemplate.query(ConstantesSQL.SQL_OBTENER_LIBROS, new LibrosMapper());
        return libros;
    }

    @Override
    public void borrarLibro(long id) {
        this.jdbcTemplate.update(ConstantesSQL.SQL_BORRAR_LIBRO, id);
    }

    @Override
    public void actualizarLibro(Libro libro) {

    }
}
