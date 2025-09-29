package controllers.admin;

import daos.LibrosDAO;
import daosImpl.LibrosDAOImpl;
import modelo.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrosControllerAdmin {

    @RequestMapping("admin/libros/crear")
    public String crear(Model model) {
        // Vamos a decir los valores por defecto del libro que le llega al springform

        Libro nuevo = new Libro();
        nuevo.setPrecio(1.0);
        model.addAttribute("libro", nuevo);

        return "nuevo_libro.jsp";
    }

    @RequestMapping("admin/libros/guardarNuevoLibro")
    public String guardarNuevoLibro(Libro libro){
        // Gracias a spring ya tengo un objeto de libro, con todos los insertaddos en el formulario
        LibrosDAO dao = new LibrosDAOImpl();
        dao.registrarLibro(libro);
        return "nuevo_libro_ok.jsp";
    }

}
