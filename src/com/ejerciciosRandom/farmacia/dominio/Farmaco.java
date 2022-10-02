package com.ejerciciosRandom.farmacia.dominio;

public class Farmaco {

    private final String nombre;
    private final int cantidadGramos;
    private int cantidad;
    private int precio;
    private final int CANTIDAD_MAXIMA = 10;

    public Farmaco(String nombre, int cantidadGramos, int cantidad, int precio) {

        this.nombre = nombre;
        this.cantidadGramos = cantidadGramos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cantidad = CANTIDAD_MAXIMA;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadGramos() {
        return cantidadGramos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
