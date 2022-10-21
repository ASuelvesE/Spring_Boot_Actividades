package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.ram.EntrenamientosServicesRAM;
import com.example.Actividad5.Actividad5.services.IEntrenamientosServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntrenamientosController {

    IEntrenamientosServices<Entrenamiento> services;

    public EntrenamientosController(){
        this.services = new EntrenamientosServicesRAM();
    }
    @GetMapping("/entrenamientos")
    List<Entrenamiento> getAll(){
        return services.getAll();
    }
    @GetMapping("/entrenamientos/{id}")
    Entrenamiento getById(@PathVariable Long id){
        return services.getById(id);
    }
    @PostMapping(value = "/entrenamientos",produces = MediaType.APPLICATION_JSON_VALUE)
    Entrenamiento save(List<Ejercicio> ejercicios,Date fecha){
        System.err.println(fecha);
        System.err.println(ejercicios);
        return services.save(fecha,ejercicios);
    }
    @PutMapping(value = "/entrenamientos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    Entrenamiento update(@PathVariable Long id, @RequestBody List<Jugador> asistentes){
        return services.update(id,asistentes);
    }
    @DeleteMapping("/entrenamientos/{id}")
    List<Entrenamiento> delete(@PathVariable Long id){
        return services.delete(id);
    }

}
