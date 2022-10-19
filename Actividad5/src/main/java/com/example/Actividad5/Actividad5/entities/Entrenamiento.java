package com.example.Actividad5.Actividad5.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entrenamiento {

    private final Long id;
    private Date fecha;
    private List<Ejercicio> ejercicios;
    private List<Jugador> asistentes;

    public Entrenamiento(Long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
        this.ejercicios = new ArrayList<>();
        this.asistentes = new ArrayList<>();
    }

    public Entrenamiento(Long id, Date fecha, List<Ejercicio> ejercicios, List<Jugador> asistentes) {
        this.id = id;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
        this.asistentes = asistentes;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public List<Jugador> getAsistentes() {
        return asistentes;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void setAsistentes(List<Jugador> asistentes) {
        this.asistentes = asistentes;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", ejercicios=" + ejercicios +
                ", asistentes=" + asistentes +
                '}';
    }
}