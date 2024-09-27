package org.raindrops.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio ur;

    public List<Usuario> listarUsuarios(){
        return (List<Usuario>)ur.findAll();
    }
    public void agregarUsuario(Usuario usuario){
        ur.save(usuario);
    }
    public void editarUsuario(){

    }
}
