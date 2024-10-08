package org.raindrops;

import org.assertj.core.api.Assertions;
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
    private UsuarioRepositorio ur;

    @Test
    public void saveTest(){
        Usuario u = new Usuario();
        u.setNombre("Rain");
        u.setContrasenia("1dsa@S!_2s_!S-2");
        u.setEmail("raindrops.bsb@gmail.com");
        u.setEdad(Integer.valueOf("25"));

        Usuario nuevo = ur.save(u);
        Assertions.assertThat(nuevo).isNotNull();
        Assertions.assertThat(nuevo.getId()).isGreaterThan(0);
    }

    @Test
    public void listAllTest(){
        Iterable<Usuario> usuario = ur.findAll();
        Assertions.assertThat(usuario).hasSizeGreaterThan(0);
        usuario.forEach(System.out::println);
    }
    @Test
    public void updateTest(){
        Integer i = 1;
        Optional<Usuario> antiguo = ur.findById(i);
        Usuario user = antiguo.get();
        user.setContrasenia("7minutes");
        ur.save(user);
        Assertions.assertThat(user.getContrasenia()).isEqualTo("7minutes");
    }
    @Test
    public void getTest(){
        Integer i = 1;
        Optional<Usuario> antiguo = ur.findById(i);
        Assertions.assertThat(antiguo).isPresent();
        System.out.println(antiguo.get());
    }
    @Test
    public void deletedTest(){
        Integer i = 1;
        ur.deleteById(i);
        Optional<Usuario> antiguo = ur.findById(i);
        Assertions.assertThat(antiguo).isNotPresent();
    }
}
