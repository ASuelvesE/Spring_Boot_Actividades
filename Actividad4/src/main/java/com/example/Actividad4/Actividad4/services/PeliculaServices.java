package com.example.Actividad4.Actividad4.services;

import com.example.Actividad4.Actividad4.dao.Dao;
import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;

import java.util.Iterator;
import java.util.List;

public class PeliculaServices implements ICrudService<Pelicula> {
    @Override
    public List<Pelicula> findAll(Long id) {
        for(Usuario u : Dao.getInstance().getListaUsuarios()){
            if(u.getId() == id){
                return u.getPeliculas();
            }
        }
        return null;
    }

    @Override
    public List<Pelicula> save(Pelicula pelicula,Long id) {
        for(Usuario u : Dao.getInstance().getListaUsuarios()){
            if(u.getId() == id){
                u.getPeliculas().add(pelicula);
                Dao.getInstance().getListaPeliculas().add(pelicula);
                return u.getPeliculas();
            }
        }
        return null;
    }

    @Override
    public Pelicula update(Long id, Pelicula u) {
        return null;
    }

    @Override
    public List<Pelicula> updateList(Long id, Pelicula pelicula) {
        for(Usuario u : Dao.getInstance().getListaUsuarios()){
            if(u.getId() == id){
                for(int i=0; i<u.getPeliculas().size();i++){
                    if(u.getPeliculas().get(i).getNombre().equalsIgnoreCase(pelicula.getNombre())){
                        u.getPeliculas().get(i).setDuracion(pelicula.getDuracion());
                        return u.getPeliculas();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Pelicula> delete(Long id, String name) {
        for(Usuario u : Dao.getInstance().getListaUsuarios()){
            if(u.getId() == id){
                Iterator it = u.getPeliculas().iterator();
                while(it.hasNext()){
                    Pelicula p = (Pelicula) it.next();
                    if(p.getNombre().equalsIgnoreCase(name)){
                        it.remove();
                        return u.getPeliculas();
                    }
                }
            }
        }
        return null;
    }
}
