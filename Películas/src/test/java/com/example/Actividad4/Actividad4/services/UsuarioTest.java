package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UsuarioTest {

    ICrudService<Usuario> iCrudService ;

    public UsuarioTest(){
        iCrudService = new UsuarioServices();
        Dao.getInstance().getListaUsuarios().clear();
    }

    @After
    public void clean(){
        Dao.getInstance().getListaUsuarios().clear();
    }

    @Test
    public void getAll(){
        Dao.getInstance().getListaUsuarios().add(new Usuario(5L,"UsuarioPrueba"));
        List<Usuario> usuarios = iCrudService.findAll(null);
        assertEquals(1,usuarios.size());
    }
    @Test
    public void insert(){
        Usuario usuario = new Usuario(5L,"UsuarioPrueba");
        iCrudService.save(usuario,null);
        assertEquals("UsuarioPrueba",iCrudService.findAll(null).get(0).getNombre());
    }
    @Test
    public void updateUser(){
        Pelicula pelicula = new Pelicula("PeliculaPrueba","2:35");
        Usuario usuario = new Usuario(5L,"UsuarioPrueba");
        usuario.add(pelicula);
        Dao.getInstance().getListaUsuarios().add(usuario);

        Pelicula peliculaActualizada = new Pelicula("UpdateFilm","5:35");
        Usuario usuarioActualizado = new Usuario(5L,"UsuarioPrueba");
        usuarioActualizado.add(peliculaActualizada);

        iCrudService.update(5L,usuarioActualizado);
        assertEquals("UpdateFilm",iCrudService.findAll(null).get(0).getPeliculas().get(0).getNombre());
    }

    @Test
    public void deleteUser(){
        Usuario usuario = new Usuario(5L,"Prueba");
        Dao.getInstance().getListaUsuarios().add(usuario);
        iCrudService.delete(5L,null);
        assertEquals(true,iCrudService.findAll(null).isEmpty());
    }
}
