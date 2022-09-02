package com.dispensador.dominio;

public class Mekato {
    private String nombre;
    private int codigo;
    private int cantidad;

    public Mekato(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
