package com.example.Actividad5.Actividad5.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ejercicio {

    private final Long id;
    private final String titulo;
    private String descripcion;
    private List<String> etiquetas;
    private String duracion;
    private HashMap<String,Integer> dureza;
    private List<String> materiales;
    private HashMap<String,String> recursosMultimedia;

    public Ejercicio(Long id, String titulo, String descripcion, String duracion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.etiquetas = new ArrayList<>();
        this.dureza = new HashMap<>();
        this.materiales = new ArrayList<>();
        this.recursosMultimedia = new HashMap<>();
    }

    public Ejercicio(Long id, String titulo, String descripcion, List<String> etiquetas, String duracion, HashMap<String, Integer> dureza, List<String> materiales, HashMap<String, String> recursosMultimedia) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
        this.duracion = duracion;
        this.dureza = dureza;
        this.materiales = materiales;
        this.recursosMultimedia = recursosMultimedia;
    }

    public Ejercicio(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public String getDuracion() {
        return duracion;
    }

    public HashMap<String, Integer> getDureza() {
        return dureza;
    }

    public List<String> getMateriales() {
        return materiales;
    }

    public HashMap<String, String> getRecursosMultimedia() {
        return recursosMultimedia;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setDureza(HashMap<String, Integer> dureza) {
        this.dureza = dureza;
    }

    public void setMateriales(List<String> materiales) {
        this.materiales = materiales;
    }

    public void setRecursosMultimedia(HashMap<String, String> recursosMultimedia) {
        this.recursosMultimedia = recursosMultimedia;
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", etiquetas=" + etiquetas +
                ", duracion='" + duracion + '\'' +
                ", dureza=" + dureza +
                ", materiales=" + materiales +
                ", recursosMultimedia=" + recursosMultimedia +
                '}';
    }
}
