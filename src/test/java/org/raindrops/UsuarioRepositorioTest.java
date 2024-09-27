package org.raindrops;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.raindrops.usuario.Usuario;
import org.raindrops.usuario.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositorioTest {

    @Autowired
    private UsuarioRepositorio rp;

    @Test
    public void saveTest(){
        Usuario u = new Usuario();
        u.setUsuario("Rain");
        u.setContrasenia("1dsa@S!_2s_!S-2");
        u.setEmail("raindrops.bsb@gmail.com");
        u.setEdad("25");

        Usuario nuevo = rp.save(u);
        Assertions.assertThat(nuevo).isNotNull();
        Assertions.assertThat(nuevo.getId()).isGreaterThan(0);
    }

    @Test
    public void listAllTest(){
        Iterable<Usuario> usuario = rp.findAll();
        Assertions.assertThat(usuario).hasSizeGreaterThan(0);
        usuario.forEach(System.out::println);
    }
    @Test
    public void updateTest(){
        Integer i = 1;
        Optional<Usuario> antiguo = rp.findById(i);
        Usuario user = antiguo.get();
        user.setContrasenia("7minutes");
        rp.save(user);
        Assertions.assertThat(user.getContrasenia()).isEqualTo("7minutes");
    }
    @Test
    public void getTest(){
        Integer i = 1;
        Optional<Usuario> antiguo = rp.findById(i);
        Assertions.assertThat(antiguo).isPresent();
        System.out.println(antiguo.get());
    }
    @Test
    public void deletedTest(){
        Integer i = 1;
        rp.deleteById(i);
        Optional<Usuario> antiguo = rp.findById(i);
        Assertions.assertThat(antiguo).isNotPresent();
    }
}
