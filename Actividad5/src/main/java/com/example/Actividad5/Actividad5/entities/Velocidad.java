package com.example.Actividad5.Actividad5.entities;

public enum Velocidad {
    HIGH(3),MEDIUM(2),LOW(1);
    private  final int numero;

    Velocidad(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}

