package com.example.Actividad4.Actividad4.restcontroller;

import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import com.example.Actividad4.Actividad4.services.ICrudService;
import com.example.Actividad4.Actividad4.services.PeliculaServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaRestController {

    ICrudService iCrudService;

    public PeliculaRestController(){
        iCrudService = new PeliculaServices();
    }


    @GetMapping("/usuario/{id}/peliculas")
    List<Pelicula> getAllByUser(@PathVariable(name = "id") Long id){
        return iCrudService.findAll(id);
    }
    @PostMapping("/usuario/{id}/peliculas")
    List<Pelicula> saveNewUser(@PathVariable(name = "id") Long id,
                               @RequestBody Pelicula pelicula){
        return iCrudService.save(pelicula,id);
    }
    @PutMapping("/usuarios/{id}/pelicula/{nombre}")
    List<Pelicula> updateUser(@PathVariable(name = "id") Long id,
                              @PathVariable(name = "nombre") String nombre,
                              String duracion){
        return iCrudService.updateList(id,new Pelicula(nombre,duracion));
    }
    @DeleteMapping("/usuarios/{id}/pelicula/{nombre}")
    List<Pelicula> deleteFilmByUser(@PathVariable(name = "id") Long id,
                                    @PathVariable(name = "nombre") String nombre){
        return iCrudService.delete(id,nombre);
    }
}
