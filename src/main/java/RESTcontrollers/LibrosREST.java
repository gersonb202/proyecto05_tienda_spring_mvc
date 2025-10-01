package RESTcontrollers;

import com.google.gson.Gson;
import daosImpl.LibrosDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrosREST {

    @Autowired
    @Qualifier("librosDAO")
    private LibrosDAOImpl librosDAO;

    // Esta ruta será invocada desde javascript, para recibir un json con el listado
    // de libros
    // ??
    @RequestMapping("librosREST/obtener")
    public ResponseEntity<String> obtener(){
        String libtrosJSON = new Gson().toJson(librosDAO.obtenerLibros());
        return new ResponseEntity<>(libtrosJSON, HttpStatus.OK);
    }

}
