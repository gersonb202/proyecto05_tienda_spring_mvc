package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

    @RequestMapping("inicio")
    public String inicio(){

        // Vamos a decirle a spring mvc que lo que indique en el return
        // Lo busque en WEB-INF/jsps
        // y también que ponga.jsp al final
        return "tienda";
    }

}
