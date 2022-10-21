package com.ejerciciosRandom.farmacia.dominio;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int dinero;
    private String nombre;
    private long cedula;
    private String ocupacion;
    List<Farmaco> compras = new ArrayList<>();

    public Persona(int dinero, String nombre, long cedula) {
        this.dinero = dinero;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Persona(String nombre, String ocupacion) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

}
