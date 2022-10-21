package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.entities.enums.Recuperacion;
import com.example.Actividad5.Actividad5.entities.enums.Resistencia;
import com.example.Actividad5.Actividad5.entities.enums.Velocidad;
import com.example.Actividad5.Actividad5.services.ram.EntrenamientosServicesRAM;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class EntrenamientosTest {

    IEntrenamientosServices<Entrenamiento> services;
    public EntrenamientosTest(){
        services = new EntrenamientosServicesRAM();
    }
    @Before
    public void clean(){
        Ram.getInstance().getEntrenamientos().clear();
        Entrenamiento.reseteaContador();
        HashMap<String, Integer> dureza = new HashMap<>();
        dureza.put(Recuperacion.class.getName(),Recuperacion.HIGH.getNumero());
        dureza.put(Resistencia.class.getName(),Resistencia.MEDIUM.getNumero());
        dureza.put(Velocidad.class.getName(),Velocidad.LOW.getNumero());

        HashMap<String, Integer> dureza2 = new HashMap<>();
        dureza2.put(Recuperacion.class.getName(),Recuperacion.HIGH.getNumero());
        dureza2.put(Resistencia.class.getName(),Resistencia.HIGH.getNumero());
        dureza2.put(Velocidad.class.getName(),Velocidad.MEDIUM.getNumero());

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("EjercicioTest","DescripcionTest","10:00",dureza));
        ejercicios.add(new Ejercicio("EjercicioTest2","DescripcionTest2","20:00",dureza2));

        List<Jugador> asistentes = new ArrayList<>();
        asistentes.add(new Jugador("123","nombreTest","apellidosTest"));
        asistentes.add(new Jugador("456","nombreTest","apellidosTest"));
        asistentes.add(new Jugador("789","nombreTest2","apellidosTest2"));

        List<Ejercicio> ejercicios2 = new ArrayList<>();
        ejercicios2.add(new Ejercicio("EjercicioTest","DescripcionTest","10:00",dureza));

        List<Jugador> asistentes2 = new ArrayList<>();
        asistentes2.add(new Jugador("123","nombreTest","apellidosTest"));

        Ram.getInstance().getEntrenamientos().add(new Entrenamiento(new Date(),ejercicios,asistentes));
        Ram.getInstance().getEntrenamientos().add(new Entrenamiento(new Date(),ejercicios2,asistentes2));
    }
    @Test
    public void getAll(){
        assertEquals(2,services.getAll().size());
    }
    @Test
    public void getById(){
        Entrenamiento e = services.getById(1L);
        assertEquals(Optional.of(7L),e.getDurezaMedia());
    }
    @Test
    public void save(){
        Entrenamiento e = services.save(new Entrenamiento(new Date()));
        assertEquals(3L,Ram.getInstance().getEntrenamientos().size());
    }
}
