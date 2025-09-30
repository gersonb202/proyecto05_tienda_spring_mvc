package mappers;


import modelo.Libro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// Para que spring jdbc me ayude a obtener libros de la base de datos
// debo decirle como hacerlo en un mapper:
public class LibrosMapper implements RowMapper<Libro> {

    @Override
    public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Libro l = new Libro();
        l.setTitulo(rs.getString("titulo"));
        l.setPrecio(rs.getDouble("precio"));
        l.setDescripcion(rs.getString("descripcion"));
        l.setId(rs.getLong("id"));
        return l;
    }

}
