package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;

import java.util.Date;
import java.util.List;

public interface IEntrenamientosServices<Entrenamiento> {

    public List<Entrenamiento> getAll();
    public Entrenamiento getById(Long id);
    public Entrenamiento save(Date fecha, List<Ejercicio> ejercicios);
    public Entrenamiento update(Long id,Entrenamiento e);
    public List<Entrenamiento> delete(Long id);
}
