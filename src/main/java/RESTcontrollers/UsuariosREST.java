package RESTcontrollers;

import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import servicios.ServicioUsuarios;

@Controller
public class UsuariosREST {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping("usuariosREST/registrar")
    public ResponseEntity<String> registrar(String nombre, String email, String pass){
        System.out.println("Voy a registrar: " + nombre + ", " + email + " y " + pass);
        servicioUsuarios.registrarUsuario(new Usuario(nombre, email, pass));
        return new ResponseEntity<String>("Registro ok, ya puedes identificarte", HttpStatus.OK);
    }

}
