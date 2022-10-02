package com.ejerciciosRandom.farmacia.dominio;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int dinero;
    private String nombre;
    List<Farmaco> compras = new ArrayList<>();


    public Persona(String nombre) {
        this.nombre = nombre;
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


}
