package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrosController {

    @RequestMapping("/libros/listar")
    public String listar() {
        System.out.println("Hola desde un controlador de Spring MVC");
        // Pedir libros a la base de datos
        // Spring JDBC: facilidades para usar BDs
        // DAO: Data Access Object -> Separar las operaciones de BDs en clases concretas


        return "libros.jsp";
    }

}
