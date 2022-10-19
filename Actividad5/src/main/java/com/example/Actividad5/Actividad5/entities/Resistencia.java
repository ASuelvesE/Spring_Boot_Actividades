package com.example.Actividad5.Actividad5.entities;

public enum Resistencia {
    HIGH(3),MEDIUM(2),LOW(1);
    private  final int numero;

    Resistencia(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
