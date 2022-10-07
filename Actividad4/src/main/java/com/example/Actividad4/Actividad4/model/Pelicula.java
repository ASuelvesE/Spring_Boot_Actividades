package com.example.Actividad4.Actividad4.model;

public class Pelicula {
    private String nombre;
    private String duracion;

    public Pelicula(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
