package controllers.admin;

import daos.LibrosDAO;
import daosImpl.LibrosDAOImpl;
import modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LibrosControllerAdmin {

    // Así pido una bean del contenedor de spring:
    // Consigues pedir bean de spring que tenga como id l indicado en Qualifier
    @Autowired
    @Qualifier("librosDAO")
    private LibrosDAOImpl librosDAO;


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
    public String guardarNuevoLibro(Libro libro){
        // Gracias a spring ya tengo un objeto de libro, con todos los insertaddos en el formulario
        // Lo siguiente no valdría porque no tiene asignado el dataSource:
        // LibrosDAO dao = new LibrosDAOImpl();
        librosDAO.registrarLibro(libro);
        return "admin/nuevo_libro_ok";
    }

}
