package servicios;


import modelo.Usuario;

import java.util.List;

// En java empresarial hay mucho conectos confusos
// En este caso se llama servicio a la interfaz
// que va a definir las operaciones posibles con usuarios
// casi igual que cuando hemos usado el paquete repository
// o el paquete dao
public interface ServicioUsuarios {

    void registrarUsuario(Usuario usuario);
    List<Usuario> obtenerUsuarios();

}
