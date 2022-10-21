package com.example.Actividad5.Actividad5.services;

import com.example.Actividad5.Actividad5.entities.Jugador;

import java.sql.SQLException;
import java.util.List;

public interface IJugadoresServices<Jugador> {

    public List<Jugador> getAll() throws SQLException;
    public List<Jugador> getById(Long id) throws SQLException;

    public Jugador save(Jugador jugador) throws SQLException;

    public Jugador update(Long id,Jugador jugador);
}
