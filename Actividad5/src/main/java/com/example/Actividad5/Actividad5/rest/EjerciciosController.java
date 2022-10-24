package com.example.Actividad5.Actividad5.rest;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.services.mysql.EjerciciosServicesMySQL;
import com.example.Actividad5.Actividad5.services.ram.EjerciciosServicesRAM;
import com.example.Actividad5.Actividad5.services.IEjerciciosServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EjerciciosController {

    IEjerciciosServices<Ejercicio> services;

    EjerciciosController(){
        this.services = new EjerciciosServicesMySQL();
    }

    @GetMapping("/ejercicios")
    List<Ejercicio> getAll() throws SQLException {
        try{
            return services.getAll();
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/ejercicios/{id}")
    Ejercicio getById(@PathVariable Long id) throws SQLException {
        try{
            return services.getById(id);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    @PostMapping(value = "/ejercicios",produces = MediaType.APPLICATION_JSON_VALUE)
    Ejercicio save(@RequestBody Ejercicio ej) throws SQLException {
        try{
            return services.save(ej);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

}
