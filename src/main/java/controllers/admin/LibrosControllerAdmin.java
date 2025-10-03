package controllers.admin;

import daos.LibrosDAO;
import modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import utilidades.GestorArchivos;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LibrosControllerAdmin {

    // Así pido una bean del contenedor de spring:
    // Consigues pedir bean de spring que tenga como id l indicado en Qualifier
    @Autowired
    // No es necesario indicar la id de la bean del contenedor de spring que estamos pidiendo
    // si solo hay una bean del tipo de dato pedido
//    @Qualifier("librosDAO")
    private LibrosDAO librosDAO;
    // De esta forma hemos pedido al contendor de spring
    // la única bean/objeto  que tengga de una clase que implemente librosDAO


    @RequestMapping("listarLibros")
    public String listarLibros(Model modelo){
        List<Libro> libros = librosDAO.obtenerLibros();
        modelo.addAttribute("libros", libros);
        // Codigo de prueba para comprobar que tengo los libros
        for(Libro libro : libros){
            System.out.println("Libro: " + libro.getTitulo());
        }
        return "admin/libros";
    }

    @RequestMapping("crearLibro")
    public String crear(Model model) {
        // Vamos a decir los valores por defecto del libro que le llega al springform

        Libro nuevo = new Libro();
        nuevo.setPrecio(1.0);
        model.addAttribute("libro", nuevo);

        return "admin/nuevo_libro";
    }

    @RequestMapping("guardarNuevoLibro")
    public String guardarNuevoLibro(Libro libro, HttpServletRequest request){
        // Gracias a spring ya tengo un objeto de libro, con todos los insertaddos en el formulario
        // Lo siguiente no valdría porque no tiene asignado el dataSource:
        // LibrosDAO dao = new LibrosDAOImpl();
        librosDAO.registrarLibro(libro);

        // Una vez registrado el libro en base de datos, vamos a guardar la imagen en una carpeta
        String rutaReal = request.getServletContext().getRealPath("");
        GestorArchivos.guardarImagenLibro(libro, rutaReal);

        return "admin/nuevo_libro_ok";
    }

    @RequestMapping("borrarLibro")
    public String borrarLibro(String id, Model modelo){
        librosDAO.borrarLibro(Long.parseLong(id));
        return listarLibros(modelo);
    }

    // Para que sirve el model??
    @RequestMapping("modificarLibro")
    public String modificarLibro(String id, Model modelo){
        Libro libro = librosDAO.obtenerLibroId(Long.parseLong(id));
        modelo.addAttribute("libroEditar", libro);
        return "admin/editar_libro";
    }
    @RequestMapping("guardarCambiosLibro")
    public String guardarCambiosLibro(Libro libro, Model modelo){
        librosDAO.actualizarLibro(libro);
        return listarLibros(modelo);
    }

}
