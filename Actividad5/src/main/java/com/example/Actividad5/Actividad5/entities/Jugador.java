package com.example.Actividad5.Actividad5.entities;

import java.sql.Date;

public class Jugador {

    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private Resistencia resistencia;
    private Velocidad velocidad;
    private Recuperacion recuperacion;

    public Jugador(Long id,String dni, String nombre, String apellidos, Date fechaNacimiento, Resistencia resistencia, Velocidad velocidad, Recuperacion recuperacion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.recuperacion = recuperacion;
    }

    public Jugador(Long id,String dni, String nombre, String apellidos) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public Jugador(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Resistencia getResistencia() {
        return resistencia;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    public Recuperacion getRecuperacion() {
        return recuperacion;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", resistencia=" + resistencia +
                ", velocidad=" + velocidad +
                ", recuperacion=" + recuperacion +
                '}';
    }
}
