package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UsuarioTest {

    ICrudService<Usuario> iCrudService ;

    public UsuarioTest(){
        iCrudService = new UsuarioServices();
    }

    @Test
    public void getAll(){
        List<Usuario> usuarios = iCrudService.findAll(null);
        assertEquals(1,usuarios.size());
    }
    @Test
    public void insert(){
        Usuario usuario = new Usuario(2L,"Prueba");
        iCrudService.save(usuario,null);
        assertEquals("Prueba",iCrudService.findAll(null).get(1).getNombre());
    }
    @Test
    public void updateUser(){
        Pelicula pelicula = new Pelicula("NombreActualizado","2:35");
        Usuario usuario = new Usuario(null,null);
        usuario.add(pelicula);
        iCrudService.update(1L,usuario);
        assertEquals("NombreActualizado",iCrudService.findAll(null).get(0).getPeliculas().get(0).getNombre());
    }

    @Test
    public void deleteUser(){
        Usuario usuario = new Usuario(2L,"Prueba");
        iCrudService.save(usuario,null);
        iCrudService.delete(2L,null);
        assertEquals(1,iCrudService.findAll(null).size());
    }
}
