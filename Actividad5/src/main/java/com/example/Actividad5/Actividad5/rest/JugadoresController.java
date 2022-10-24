package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.IJugadoresServices;
import com.example.Actividad5.Actividad5.services.mysql.JugadoresServicesMySQL;
import com.example.Actividad5.Actividad5.services.ram.JugadoresServicesRAM;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JugadoresController {

    IJugadoresServices<Jugador> services;

    public JugadoresController(){
        services = new JugadoresServicesMySQL();
    }

    @GetMapping("/jugadores")
    List<Jugador> getAll() throws SQLException {
        try{
            return services.getAll();
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/jugadores/{id}")
    List<Jugador> getById(@PathVariable Long id)  throws SQLException{
        try{
            return services.getById(id);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    @PostMapping(value = "/jugadores",produces = MediaType.APPLICATION_JSON_VALUE)
    Jugador save(@RequestBody Jugador jugador) throws SQLException {
        try{
            return services.save(jugador);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    @PutMapping(value = "/jugadores/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Jugador update(@PathVariable Long id,@RequestBody Jugador jugador) throws  SQLException{
        try{
            return services.update(id,jugador);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
