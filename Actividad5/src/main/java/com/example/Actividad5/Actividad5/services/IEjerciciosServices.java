package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Ejercicio;

import java.sql.SQLException;
import java.util.List;

public interface IEjerciciosServices <Ejercicio> {

    public List<Ejercicio> getAll() throws SQLException;
    public Ejercicio getById(Long id) throws SQLException;
    public Ejercicio save(Ejercicio ejercicio) throws SQLException;
}
