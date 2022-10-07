package com.example.Actividad4.Actividad4.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nombre;
    private List<Pelicula> peliculas;


    public Usuario(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.peliculas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void add(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peliculas=" + peliculas +
                '}';
    }
}
