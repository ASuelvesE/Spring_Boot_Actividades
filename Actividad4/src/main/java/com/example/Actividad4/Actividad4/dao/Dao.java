package com.example.Actividad4.Actividad4.dao;

import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Dao {

    private static Dao dao;

    private List<Usuario> listaUsuarios;
    private List<Pelicula> listaPeliculas;

    private Dao(){
        listaUsuarios = new ArrayList<>();
        listaPeliculas = new ArrayList<>();
        Pelicula pelicula = new Pelicula("Origen","2:35");
        listaPeliculas.add(pelicula);
        Usuario usuario = new Usuario(1L,"Mar");
        usuario.add(pelicula);
        listaUsuarios.add(usuario);
    }


    public static Dao getInstance() {
        if(dao == null){
            dao = new Dao();
            return dao;
        } return dao;
    }


    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }


    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

}
