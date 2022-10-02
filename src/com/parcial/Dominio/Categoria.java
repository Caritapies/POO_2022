package com.parcial.Dominio;

public class Categoria {

    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    public Categoria() {
        this.nombre = "Ropa";
    }

    public String getNombre() {
        return nombre;
    }
}
