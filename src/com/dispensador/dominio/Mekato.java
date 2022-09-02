package com.dispensador.dominio;

public class Mekato {
    private String nombre;
    private int codigo;
    private int cantidad;
    private int valor;

    public Mekato(String nombre, int codigo,int valor) {
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

    public int getValor() {
        return valor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
