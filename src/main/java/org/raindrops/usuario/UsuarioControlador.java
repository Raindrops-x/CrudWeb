package org.raindrops.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio us;

    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        List<Usuario> lista = us.listarUsuarios();
        model.addAttribute("listaDeUsuarios",lista);
        return "usuarios";
    }
    @GetMapping("/shutdown")
    public String retornar(){
        return "index";
    }
}
