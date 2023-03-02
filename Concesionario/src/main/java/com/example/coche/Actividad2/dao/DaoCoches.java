package com.example.coche.Actividad2.dao;

import com.example.coche.Actividad2.model.Coche;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DaoCoches {
    private List<Coche> listaCoches;
    private static DaoCoches daoCoches;

    public DaoCoches(){
        /*
        Coche[] coches = {new Coche("123","Opel","Corsa", 10000L),
                new Coche("456","Renault","Megane", 5000L),
                new Coche("789","Ford","Focus", 25000L)
        };

        this.listaCoches = Arrays.asList(coches);

         */
        this.listaCoches = new ArrayList<>();
        this.listaCoches.add(new Coche("123","Opel","Corsa", 10000L));
        this.listaCoches.add(new Coche("456","Renault","Megane", 5000L));
        this.listaCoches.add(new Coche("789","Ford","Focus", 25000L));
    }

    public static DaoCoches getInstance() {
        if(daoCoches == null){
            daoCoches = new DaoCoches();
            return daoCoches;
        }
        return daoCoches;
    }
}
