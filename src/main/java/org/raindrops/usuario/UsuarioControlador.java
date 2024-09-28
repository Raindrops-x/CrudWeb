package org.raindrops.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio us;

    @GetMapping("/Usuarios")
    public String listarUsuarios(Model model){
        List<Usuario> lista = us.listarUsuarios();
        model.addAttribute("listaDeUsuarios",lista);
        return "usuarios";
    }
    @GetMapping("/Shutdown")
    public String retornar(){
        return "index";
    }
    @GetMapping("/Usuarios/Agregar")
    public String agregarUsuario(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());
        return "agregar";
    }
    @PostMapping("/Usuario/guardar")
    public String guardarUsuario(Usuario usuario){
        us.agregarUsuario(usuario);
        return "redirect:/Usuarios";
    }
}
