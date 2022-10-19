package com.example.Actividad5.Actividad5.entities;


import java.util.*;

public class Entrenamiento {

    private static Long contador = 1L;
    private Long id;
    private Date fecha;
    private List<Ejercicio> ejercicios;
    private List<Jugador> asistentes;

    private Long durezaMedia;

    public Entrenamiento(Date fecha) {
        this.id = contador;
        this.fecha = fecha;
        this.ejercicios = new ArrayList<>();
        this.asistentes = new ArrayList<>();
        contador ++;
    }

    public Entrenamiento(Long id, Date fecha, List<Ejercicio> ejercicios, List<Jugador> asistentes) {
        this.id = contador;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
        this.asistentes = asistentes;
        contador ++;
    }

    public Entrenamiento(Date fecha, List<Ejercicio> ejercicios) {
        this.id = contador;
        this.fecha = fecha;
        this.ejercicios = ejercicios;
        contador ++;
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