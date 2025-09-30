package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("admin")
    public String admin() {
        System.out.println("Se ejecuta el controlador de admin");
        return "admin/inicio";
    }

}
