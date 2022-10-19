package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EjerciciosTest {

    IEjerciciosServices<Ejercicio> services;

    public EjerciciosTest(){
        this.services = new EjerciciosServicesRAM();
    }
    @After
    public void clean(){
        Ram.getInstance().getEjercicios().clear();
        Ejercicio.reseteaContador();
    }
    @Test
    public void getAll(){
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest"));
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest2"));
        assertEquals(2L,services.getAll().get(1).getId());
    }

    @Test
    public void getById(){
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest"));
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest2"));
        assertEquals("EjercicioTest2",services.getById(2L).getTitulo());
    }
    @Test
    public void save(){
        assertEquals("EjercicioTest2",services.save(new Ejercicio("EjercicioTest2")).getTitulo());
    }

}
