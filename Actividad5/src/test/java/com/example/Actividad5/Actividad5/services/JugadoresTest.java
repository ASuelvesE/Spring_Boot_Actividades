package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.IJugadoresServices;
import com.example.Actividad5.Actividad5.services.JugadoresServicesRAM;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JugadoresTest {

    IJugadoresServices<Jugador> services;

    public JugadoresTest(){
        services = new JugadoresServicesRAM();

    }

    @After
    public void clean(){
        Ram.getInstance().getJugadores().clear();
        Jugador.reseteaContador();
    }

    @Test
    public void saveAndGetAll(){
        services.save(new Jugador("123","nombreTest","apellidosTest"));
        assertEquals(1,services.getAll().size());
    }
    @Test
    public void update(){
        services.save(new Jugador("123","nombreTest","apellidosTest"));
        services.save(new Jugador("456","nombreTest2","apellidosTest2"));
        Jugador actualizado = services.update(2L,new Jugador("456","nombreActualizado","apellidosTest2"));
        assertEquals("nombreActualizado",actualizado.getNombre());
    }

}
