package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.mysql.EntrenamientosServicesMySQL;
import com.example.Actividad5.Actividad5.services.ram.EntrenamientosServicesRAM;
import com.example.Actividad5.Actividad5.services.IEntrenamientosServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntrenamientosController {

    IEntrenamientosServices<Entrenamiento> services;

    public EntrenamientosController(){
        this.services = new EntrenamientosServicesMySQL();
    }
    @GetMapping("/entrenamientos")
    List<Entrenamiento> getAll() throws SQLException {
        return services.getAll();
    }
    @GetMapping("/entrenamientos/{id}")
    Entrenamiento getById(@PathVariable Long id) throws SQLException {
        return services.getById(id);
    }
    @PostMapping(value = "/entrenamientos",produces = MediaType.APPLICATION_JSON_VALUE)
    Entrenamiento save(@RequestBody Date fecha, List<Ejercicio> ejercicios) throws SQLException {
        return services.save(fecha,ejercicios);
    }
    @PutMapping(value = "/entrenamientos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Entrenamiento update(@PathVariable Long id, @RequestBody List<Jugador> asistentes) throws SQLException {
        return services.update(id,asistentes);
    }
    @DeleteMapping("/entrenamientos/{id}")
    List<Entrenamiento> delete(@PathVariable Long id) throws SQLException {
        return services.delete(id);
    }

}
