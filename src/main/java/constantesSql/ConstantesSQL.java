package constantesSql;

public class ConstantesSQL {

    public static final String SQL_OBTENER_LIBROS = "SELECT * FROM libros ORDER BY id DESC";
    public static final String SQL_BORRAR_LIBRO = "DELETE FROM libros WHERE id = ?";
    public static final String SQL_OBTENER_LIBRO_ID = "SELECT * FROM libros WHERE id = ?";

    public static final String SQL_GUARDAR_CAMBIOS_LIBRO = "UPDATE libros SET titulo = ?, precio = ?, descripcion = ? WHERE id = ?";
}
