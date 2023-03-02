package com.example.Actividad3.Actividad3.model;

import java.util.List;


public class VideoJuego {

    private String nombre;
    private List<String> categorias;
    private Long precio;

    public VideoJuego(String nombre, List<String> categorias, Long precio) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "VideoJuego{" +
                "nombre='" + nombre + '\'' +
                ", categorias=" + categorias +
                ", precio=" + precio +
                '}';
    }
}
