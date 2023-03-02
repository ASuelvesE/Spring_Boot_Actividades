package com.example.coche.Actividad2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private Long km;

    public String toString(){
        return "Matrícula: " + this.matricula + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nKilómetros: " + this.km;
    }
}
