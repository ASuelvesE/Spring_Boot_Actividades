package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;

import java.util.Date;
import java.util.List;

public class EntrenamientosServicesRAM implements IEntrenamientosServices<Entrenamiento> {
    @Override
    public List<Entrenamiento> getAll() {
        return Ram.getInstance().getEntrenamientos();
    }

    @Override
    public Entrenamiento getById(Long id) {
        for(Entrenamiento e : Ram.getInstance().getEntrenamientos()){
            if(e.getId() == id){
                e.calculaDurezaMedia();
                return e;
            }
        }
        return null;
    }

    @Override
    public Entrenamiento save(Date fecha, List<Ejercicio> ejercicios) {
        Entrenamiento nuevo = new Entrenamiento(fecha,ejercicios);
        Ram.getInstance().getEntrenamientos().add(nuevo);
        return nuevo;
    }

    @Override
    public Entrenamiento update(Long id, Entrenamiento e) {
        return null;
    }

    @Override
    public List<Entrenamiento> delete(Long id) {
        return null;
    }
}
