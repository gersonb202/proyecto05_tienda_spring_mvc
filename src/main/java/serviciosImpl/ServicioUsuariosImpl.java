package serviciosImpl;

import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicios.ServicioUsuarios;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuarios {

    // Saber trabajar con hibernate, es tener claros
    // los conceptos básicos, y usar todos el rato en cada
    // opereación el SessionFactory de hibernate
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void registrarUsuario(Usuario usuario) {
        this.sessionFactory.getCurrentSession().save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        // Para obteneer datos a partir de consultas hay 3 formas importantes:
        // - SQL natiivo
        // - HQL -> Lenguaje de consultas de hibernate
        // - Cireteria
        Criteria c = this.sessionFactory.getCurrentSession().createCriteria(Usuario.class);
        List<Usuario> usuarios = c.list() ;
        return usuarios;
    }
}
