package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Ejercicio;

import java.util.List;

public interface IEjerciciosServices <Ejercicio> {

    public List<Ejercicio> getAll();
    public Ejercicio getById(Long id);
    public Ejercicio save(Ejercicio ejercicio);
}
