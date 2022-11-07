package com.documento.dominio;

public class Virus implements Viruseable{

    private String nombre;
    private int calidad;

    public Virus(String nombre, int calidad) {
        this.nombre = nombre;
        this.calidad = calidad;
    }

    @Override
    public boolean tieneVirus() {
        return false;
    }
}
