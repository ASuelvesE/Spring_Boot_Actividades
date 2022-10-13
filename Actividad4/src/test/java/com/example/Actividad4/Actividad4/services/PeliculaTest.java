package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PeliculaTest {

    ICrudService<Pelicula> iCrudService ;

    public PeliculaTest(){
        iCrudService = new PeliculaServices();
        Dao.getInstance().getListaUsuarios().add(new Usuario(10L,"UsuarioPrueba"));
    }

    @After
    public void clean(){
        Dao.getInstance().getListaUsuarios().get(1).getPeliculas().clear();
    }

    @Test
    public void saveNewUser(){
        iCrudService.save(new Pelicula("Prueba","1:00"),10L);
        assertEquals("Prueba",iCrudService.findAll(10L).get(0).getNombre());
    }

    @Test
    public void getAllByUser(){
        iCrudService.save(new Pelicula("Prueba","1:00"),10L);
        assertEquals(1,iCrudService.findAll(10L).size());
    }


    @Test
    public void updateUser(){
        iCrudService.save(new Pelicula("Prueba","1:00"),10L);
        iCrudService.updateList(10L,new Pelicula("Prueba","0:00"));
        assertEquals("0:00",iCrudService.findAll(10L).get(0).getDuracion());
    }

    @Test
    public void deleteFilmByUser(){
        iCrudService.save(new Pelicula("Prueba","1:00"),10L);
        iCrudService.delete(10L,"Prueba");
        assertEquals(true,iCrudService.findAll(10L).isEmpty());
    }
}
