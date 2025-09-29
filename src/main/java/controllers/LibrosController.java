package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrosController {

    @RequestMapping("/libros/listar")
    public String listar() {
        System.out.println("Hola desde un controlador de Spring MVC");
        return "libros.jsp";
    }

}
