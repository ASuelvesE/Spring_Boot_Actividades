package com.example.Actividad5.Actividad5.services.ram;

import com.example.Actividad5.Actividad5.conexion.Ram;
import com.example.Actividad5.Actividad5.entities.Ejercicio;
import com.example.Actividad5.Actividad5.services.IEjerciciosServices;

import java.util.ArrayList;
import java.util.List;

public class EjerciciosServicesRAM implements IEjerciciosServices<Ejercicio> {
    @Override
    public List getAll() {
        List<Ejercicio> lista = new ArrayList<>();
        for(Ejercicio e : Ram.getInstance().getEjercicios()){
            Ejercicio nuevo = new Ejercicio(e.getTitulo());
            nuevo.setId(e.getId());
            lista.add(nuevo);
        }
        return lista;
    }

    @Override
    public Ejercicio getById(Long id) {
        for(Ejercicio e : Ram.getInstance().getEjercicios()){
            if(e.getId() == id)
                return e;
        }
        return null;
    }

    @Override
    public Ejercicio save(Ejercicio e) {
        Ram.getInstance().getEjercicios().add(e);
        return e;
    }
}
