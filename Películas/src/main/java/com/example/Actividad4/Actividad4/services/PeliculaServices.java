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
        for(int i = 0; i<Dao.getInstance().getListaUsuarios().size();i++){
            if(Dao.getInstance().getListaUsuarios().get(i).getId() == id){
                Dao.getInstance().getListaUsuarios().get(i).getPeliculas().add(pelicula);
                Dao.getInstance().getListaPeliculas().add(pelicula);
                return Dao.getInstance().getListaUsuarios().get(i).getPeliculas();
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
        for(int i = 0; i<Dao.getInstance().getListaUsuarios().size(); i++){
            if(Dao.getInstance().getListaUsuarios().get(i).getId() == id){;
                for(int k=0; k<Dao.getInstance().getListaUsuarios().get(i).getPeliculas().size();k++){
                    if(Dao.getInstance().getListaUsuarios().get(i).getPeliculas().get(k).getNombre().equalsIgnoreCase(pelicula.getNombre())){
                        Dao.getInstance().getListaUsuarios().get(i).getPeliculas().get(k).setDuracion(pelicula.getDuracion());
                        return Dao.getInstance().getListaUsuarios().get(i).getPeliculas();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Pelicula> delete(Long id, String name) {
        for(int i = 0; i< Dao.getInstance().getListaUsuarios().size();i++){

            if(Dao.getInstance().getListaUsuarios().get(i).getId() == id){
                Iterator it = Dao.getInstance().getListaUsuarios().get(i).getPeliculas().iterator();

                while(it.hasNext()){
                    Pelicula p = (Pelicula) it.next();
                    if(p.getNombre().equalsIgnoreCase(name)){
                        it.remove();
                        return Dao.getInstance().getListaUsuarios().get(i).getPeliculas();
                    }
                }
            }
        }
        return null;
    }
}
