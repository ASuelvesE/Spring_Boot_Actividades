package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.entities.Entrenamiento;
import com.example.Actividad5.Actividad5.entities.Jugador;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IEntrenamientosServices<Entrenamiento> {

    public List<Entrenamiento> getAll() throws SQLException;
    public Entrenamiento getById(Long id) throws SQLException;
    public Entrenamiento save(Date fecha, List<Ejercicio> ejercicios) throws SQLException;
    public Entrenamiento update(Long id,List<Jugador> asistentes) throws SQLException;
    public List<Entrenamiento> delete(Long id) throws SQLException;
}
