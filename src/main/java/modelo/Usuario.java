package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "usuarios")
public class Usuario {

    private String nombre;
    private String pass;
    private String email;

    @Id
    @GeneratedValue
    private int id;

    public Usuario() {
    }

    public Usuario(String nombre, String pass, String email) {
        this.nombre = nombre;
        this.pass = pass;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
