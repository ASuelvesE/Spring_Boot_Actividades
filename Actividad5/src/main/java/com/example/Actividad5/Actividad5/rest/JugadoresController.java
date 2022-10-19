package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.IJugadoresServices;
import com.example.Actividad5.Actividad5.services.JugadoresServicesRAM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JugadoresController {

    IJugadoresServices services;

    public JugadoresController(){
        services = new JugadoresServicesRAM();
    }

    @GetMapping("/jugadores")
    List<Jugador> getAll(){
        return services.getAll();
    }
    @GetMapping("/jugadores/{id}")
    List<Jugador> getById(@PathVariable Long id){
        return services.getById(id);
    }

}
