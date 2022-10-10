package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PeliculaTest {

    ICrudService<Pelicula> iCrudService ;

    public PeliculaTest(){
        iCrudService = new PeliculaServices();
    }

    @Test
    public void getAllByUser(){
        assertEquals(1,iCrudService.findAll(1L).size());
    }

    @Test
    public void saveNewUser(){
        iCrudService.save(new Pelicula("Prueba","1:00"),1L);
        assertEquals("Prueba",iCrudService.findAll(1L).get(1).getNombre());
    }

    @Test
    public void updateUser(){
        iCrudService.updateList(1L,new Pelicula("Origen","0:00"));
        assertEquals("0:00",iCrudService.findAll(1L).get(0).getDuracion());
    }

    @Test
    public void deleteFilmByUser(){
        iCrudService.delete(1L,"Origen");
        assertEquals(0,iCrudService.findAll(1L).size());
    }
}
