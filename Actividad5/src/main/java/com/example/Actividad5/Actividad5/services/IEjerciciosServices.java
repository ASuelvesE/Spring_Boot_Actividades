package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Ejercicio;

import java.sql.SQLException;
import java.util.List;

public interface IEjerciciosServices <Ejercicio> {

    public List<Ejercicio> getAll();
    public Ejercicio getById(Long id);
    public Ejercicio save(Ejercicio ejercicio);
}
