package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;

import java.util.List;

public interface ICrudService <T>{
    public List<T> findAll(Long id);
    public List<T> save(T t,Long id);
    public T update(Long id,T t);
    public List<T> updateList(Long id, T t);
    public List<T> delete(Long id, String name);

}
