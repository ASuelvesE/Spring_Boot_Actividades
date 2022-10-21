package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.services.ram.EjerciciosServicesRAM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EjerciciosTest {

    IEjerciciosServices<Ejercicio> services;

    public EjerciciosTest(){
        this.services = new EjerciciosServicesRAM();
    }
    @Before
    public void clean(){
        Ram.getInstance().getEjercicios().clear();
        Ejercicio.reseteaContador();
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest",null,null,null,null,null,null));
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest2",null,null,null,null,null,null));
    }
    @Test
    public void getAll() throws SQLException {
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest",null,null,null,null,null,null));
        Ram.getInstance().getEjercicios().add(new Ejercicio("EjercicioTest2",null,null,null,null,null,null));
        assertEquals(2L,services.getAll().get(1).getId());
    }
    @Test
    public void getAll2() throws SQLException{
        assertEquals(2L,services.getAll().size());
    }

    @Test
    public void getById() throws SQLException{
        assertEquals("EjercicioTest2",services.getById(2L).getTitulo());
    }
    @Test
    public void save() throws SQLException{
        assertEquals("EjercicioTest2",services.save(new Ejercicio("EjercicioTest2",null,null,null,null,null,null)).getTitulo());
    }

}
