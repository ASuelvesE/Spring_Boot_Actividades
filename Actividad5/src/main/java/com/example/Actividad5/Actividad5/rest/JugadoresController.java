package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.constants.Const;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.IJugadoresServices;
import com.example.Actividad5.Actividad5.services.JugadoresServicesRAM;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JugadoresController {

    IJugadoresServices<Jugador> services;

    public JugadoresController(){
        services = new JugadoresServicesRAM();
    }

    @GetMapping(Const.API + "/jugadores/{id}")
    List<Jugador> getById(@PathVariable Long id){
        if(id == null)
            return services.getAll();
        return services.getById(id);
    }
    @PostMapping(Const.API + "/jugadores")
    Jugador save(Jugador jugador){
        return services.save(jugador);
    }
    @PutMapping(Const.API + "/jugadores/{id}")
    Jugador update(@PathVariable Long id,@RequestBody Jugador jugador){
        return services.update(id,jugador);
    }
}
