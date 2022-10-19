package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.services.EjerciciosServicesRAM;
import com.example.Actividad5.Actividad5.services.IEjerciciosServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EjerciciosController {

    IEjerciciosServices<Ejercicio> services;

    EjerciciosController(){
        this.services = new EjerciciosServicesRAM();
    }

    @GetMapping("/ejercicios")
    List<Ejercicio> getAll(){
        return services.getAll();
    }
    @GetMapping("/ejercicios/{id}")
    Ejercicio getById(@PathVariable Long id){
        return services.getById(id);
    }
    @PostMapping("/ejercicios")
    Ejercicio save(Ejercicio e){
        return services.save(e);
    }

}
