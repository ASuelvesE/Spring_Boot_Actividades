package com.example.Actividad5.Actividad5.entities;


import java.util.*;
import java.util.Date;

public class Entrenamiento {
    public static Long contador = 1L;
    private Long id;
    private Date fecha;
    private List<Ejercicio> ejercicios = new ArrayList<>();
    private List<Jugador> asistentes = new ArrayList<>();
    private Long durezaMedia;


    public Entrenamiento(Date fecha, List<Ejercicio> ejercicios, List<Jugador> asistentes, Long durezaMedia) {
        this.id = contador;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
        this.asistentes = asistentes;
        this.durezaMedia = durezaMedia;
        contador++;
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
    public void calculaDurezaMedia(){
        int sumaCondicionesFisicas = 0;
        for(Ejercicio e : this.ejercicios){
            HashMap<String,Integer> dureza = e.getDureza();
            Iterator it = dureza.values().iterator();
            while (it.hasNext()){
                sumaCondicionesFisicas += (Integer)it.next();
            }
        }
        this.durezaMedia = Long.valueOf(sumaCondicionesFisicas/this.ejercicios.size());
    }

    public Long getDurezaMedia() {
        return durezaMedia;
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
    public static void reseteaContador(){
        contador = 1L;
    }
}