package com.documento.dominio;

public abstract class Documento extends Archivo{
    private String nombre;

    public Documento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
