package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.ram.JugadoresServicesRAM;
import org.junit.Before;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JugadoresTest {

    IJugadoresServices<Jugador> services;

    public JugadoresTest(){
        services = new JugadoresServicesRAM();
    }

    @Before
    public void clean(){
        Ram.getInstance().getJugadores().clear();
        Jugador.reseteaContador();
        Ram.getInstance().getJugadores().add(new Jugador("123","nombreTest","apellidosTest"));
        Ram.getInstance().getJugadores().add(new Jugador("456","nombreTest","apellidosTest"));
        Ram.getInstance().getJugadores().add(new Jugador("789","nombreTest2","apellidosTest2"));
    }

    @Test
    public void getAll(){
        assertEquals(3,services.getAll().size());
    }
    @Test
    public void getById(){
        assertEquals(1,services.getById(2L).size());
    }
    @Test
    public void save(){
        Jugador nuevo = services.save(new Jugador("111","nombreNuevo","apellidosTest"));
        assertEquals(4,Ram.getInstance().getJugadores().size());
    }
    @Test
    public void update(){
        Jugador actualizado = services.update(2L,new Jugador("456","nombreActualizado","apellidosTest2"));
        assertEquals("nombreActualizado",actualizado.getNombre());
    }

}
