package com.example.Actividad3.Actividad3.services;

import com.example.Actividad3.Actividad3.dao.DaoVideojuegos;
import com.example.Actividad3.Actividad3.model.VideoJuego;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServiceVideojuegos implements IServiceCRUD<VideoJuego> {

    @Override
    public List<VideoJuego> findAll(String nombre) {
        if(nombre == null){
            return DaoVideojuegos.getInstance().getListaVideojuegos();
        }else {
            List<VideoJuego> videojuegos = DaoVideojuegos.getInstance().getListaVideojuegos();
            for(VideoJuego v : videojuegos){
                if(v.getNombre().equalsIgnoreCase(nombre)){
                    List<VideoJuego> salida = new ArrayList<>();
                    salida.add(v);
                    return salida;
                }
            }
        }
        return null;
    }

    @Override
    public VideoJuego save(VideoJuego nuevo) {
        DaoVideojuegos.getInstance().getListaVideojuegos().add(nuevo);
        return nuevo;
    }

    @Override
    public VideoJuego updatePrice(String nombre, Long precio) {
        for(VideoJuego v : DaoVideojuegos.getInstance().getListaVideojuegos()){
            if(v.getNombre().equalsIgnoreCase(nombre)){
                v.setPrecio(precio);
                return v;
            }
        }
        return null;
    }

    @Override
    public List<VideoJuego> deleteByName(String nombre) {
        Iterator it = DaoVideojuegos.getInstance().getListaVideojuegos().iterator();
        while(it.hasNext()){
            VideoJuego videoJuego = (VideoJuego) it.next();
            if(videoJuego.getNombre().equalsIgnoreCase(nombre)){
                it.remove();
            }
        }
        return DaoVideojuegos.getInstance().getListaVideojuegos();
    }
}
