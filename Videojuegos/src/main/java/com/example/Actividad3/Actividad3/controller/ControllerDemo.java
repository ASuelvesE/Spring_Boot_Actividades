package com.example.Actividad3.Actividad3.controller;

import com.example.Actividad3.Actividad3.model.VideoJuego;
import com.example.Actividad3.Actividad3.services.IServiceCRUD;
import com.example.Actividad3.Actividad3.services.ServiceVideojuegos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerDemo {


    IServiceCRUD<VideoJuego> iserviceCRUD;

    public ControllerDemo(){
        iserviceCRUD = new ServiceVideojuegos();
    }

    @GetMapping("/videojuegos")
    List<VideoJuego> videojuegos(@RequestParam(required = false,name = "nombre") String nombre) {
        return iserviceCRUD.findAll(nombre);
    }

    @PostMapping("/videojuegos")
    VideoJuego nuevo(VideoJuego nuevo){
        return iserviceCRUD.save(nuevo);
    }

    @PutMapping("/videojuegos/{nombre}")
    VideoJuego actualizaPrecio(@PathVariable String nombre, Long precio){
        return iserviceCRUD.updatePrice(nombre,precio);
    }
    @DeleteMapping("/videojuegos/{nombre}")
    List<VideoJuego> borraVideojuego(@PathVariable(name = "nombre") String nombre){
        return iserviceCRUD.deleteByName(nombre);
    }
}
