package com.example.Actividad3.Actividad3.dao;

import com.example.Actividad3.Actividad3.model.VideoJuego;

import java.util.ArrayList;
import java.util.List;


public class DaoVideojuegos {

    private List<VideoJuego> listaVideojuegos;
    private static DaoVideojuegos daoVideojuegos;

    private DaoVideojuegos(){
        listaVideojuegos = new ArrayList<>();
        List<String> categorias = new ArrayList<>();
        categorias.add("Deportes");
        listaVideojuegos.add(new VideoJuego("FIFA 23",categorias,50L));
    }

    public static DaoVideojuegos getInstance() {
        if(daoVideojuegos == null){
            daoVideojuegos = new DaoVideojuegos();
        }
        return daoVideojuegos;
    }

    public List<VideoJuego> getListaVideojuegos() {
        return listaVideojuegos;
    }

}
