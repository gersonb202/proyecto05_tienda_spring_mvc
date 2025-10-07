package controllers.admin;

import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import servicios.ServicioUsuarios;

@Controller
public class UsuariosControllerAdmin {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @RequestMapping("crearUsuario")
    public String crearUsuario(Model modelo){
        modelo.addAttribute("nuevoUsuario", new Usuario());
        return "admin/nuevo_usuario";
    }

    @RequestMapping("guardarNuevoUsuario")
    public String guardarNuevoUsuario(Usuario nuevoUsuario){
        servicioUsuarios.registrarUsuario(nuevoUsuario);
        return "admin/nuevo_usuario_ok";
    }

    @RequestMapping("listarUsuarios")
    public String listarUsuarios(Model modelo){
        modelo.addAttribute("usuarios", servicioUsuarios.obtenerUsuarios());
        return "admin/usuarios";
    }

    @RequestMapping("borrarUsuario")
    public String borrarUsuario(String id, Model modelo){
        servicioUsuarios.borrarUsuario(Integer.parseInt(id));
        return listarUsuarios(modelo);
    }

    @RequestMapping("editarUsuario")
    public String editarUsuario(String id, Model modelo){
        modelo.addAttribute("usuarioEditar", servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(id)));
        return "admin/editar_usuario";
    }

    @RequestMapping("guardarCambiosUsuario")
    public String guardarCambiosUsuario(Usuario usuarioEditar, Model modelo){
        servicioUsuarios.actualizarUsuario(usuarioEditar);
        return listarUsuarios(modelo);
    }

}
