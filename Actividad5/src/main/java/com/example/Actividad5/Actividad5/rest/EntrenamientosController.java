package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.constants.Const;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;
import com.example.Actividad5.Actividad5.services.ram.EntrenamientosServicesRAM;
import com.example.Actividad5.Actividad5.services.IEntrenamientosServices;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EntrenamientosController {

    IEntrenamientosServices<Entrenamiento> services;

    public EntrenamientosController(){
        this.services = new EntrenamientosServicesRAM();
    }
    @GetMapping(Const.API + "/entrenamientos")
    List<Entrenamiento> getAll(){
        return services.getAll();
    }
    @GetMapping(Const.API + "/entrenamientos/{id}")
    Entrenamiento getById(@PathVariable Long id){
        return services.getById(id);
    }
    @PostMapping(Const.API + "/entrenamientos")
    Entrenamiento save(Date fecha, List<Ejercicio> ejercicios){
        return services.save(fecha,ejercicios);
    }
    @PutMapping(Const.API + "/entrenamientos/{id}")
    Entrenamiento update(@PathVariable Long id, @RequestBody List<Jugador> asistentes){
        return services.update(id,asistentes);
    }
    @DeleteMapping(Const.API + "/entrenamientos/{id}")
    List<Entrenamiento> delete(@PathVariable Long id){
        return services.delete(id);
    }

}
