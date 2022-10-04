package com.example.coche.Actividad2.controller;

import com.example.coche.Actividad2.dao.DaoCoches;
import com.example.coche.Actividad2.model.Coche;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerCoches {

    @RequestMapping("/")
    String muestraCoches(
            Model model,
            @RequestParam(required = false,name = "matricula") String matricula){
        if(matricula != null){
            for(Coche coche : DaoCoches.getInstance().getListaCoches()){
                if(coche.getMatricula().equalsIgnoreCase(matricula)){
                    List<Coche> listaMatricula = new ArrayList<>();
                    listaMatricula.add(coche);
                    model.addAttribute("lista",listaMatricula);
                }
            }
        }else {
            model.addAttribute("lista",DaoCoches.getInstance().getListaCoches());
        }
       return "concesionario";
    }
    @RequestMapping("/nuevo")
    String nuevo(){
        return "nuevo";
    }
    @PostMapping("/nuevo")
    String nuevoCoche(Model model, Coche nuevo){
        System.out.println(nuevo);
        DaoCoches.getInstance().getListaCoches().add(nuevo);
        model.addAttribute("lista",DaoCoches.getInstance().getListaCoches());
        return "concesionario";
    }
}
