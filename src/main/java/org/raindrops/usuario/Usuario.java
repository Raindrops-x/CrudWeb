package org.raindrops.usuario;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 20)
    private String usuario;
    @Column(nullable = false,length = 20)
    private String contrasenia;
    @Column(nullable = false,unique = true,length = 50)
    private String email;
    @Column(nullable = false,length = 2)
    private String edad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", email='" + email + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
