package com.example.Actividad3.Actividad3.services;

import com.example.Actividad3.Actividad3.model.VideoJuego;

import java.util.List;

public interface IServiceCRUD<T> {

    public List<T> findAll(String nombre);
    public T save(T nuevo);
    public T updatePrice(String nombre, Long precio);
    public  List<T> deleteByName(String nombre);
}
