package com.example.Actividad4.Actividad4.restcontroller;

import com.example.Actividad4.Actividad4.model.Pelicula;
import com.example.Actividad4.Actividad4.model.Usuario;
import com.example.Actividad4.Actividad4.services.ICrudService;
import com.example.Actividad4.Actividad4.services.UsuarioServices;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    ICrudService<Usuario> iCrudService ;

    public UsuarioRestController(){
        iCrudService = new UsuarioServices();
    }

    @GetMapping("/usuarios")
    List<Usuario> getAll(){
        return iCrudService.findAll(null);
    }
    @PostMapping(path = "/usuarios", consumes = {MediaType.APPLICATION_JSON_VALUE})
    List<Usuario> insert(@RequestBody Usuario u){
        return iCrudService.save(u,null);
    }
    @PutMapping(path = "/usuarios/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    Usuario updateUser(@PathVariable(name = "id") Long id,
                       @RequestBody Usuario u){

        return iCrudService.update(id,u);
    }
    @DeleteMapping("/usuarios/{id}")
    List<Usuario> deleteUser(@PathVariable(name = "id") Long id){
        return iCrudService.delete(id,null);
    }


}
