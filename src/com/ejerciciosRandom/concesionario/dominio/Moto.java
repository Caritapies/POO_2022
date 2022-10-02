package com.ejerciciosRandom.concesionario.dominio;

public class Moto {

    private final long serial;
    private final String marca;
    private final int precio;
    private final int cilindraje;
    private final boolean Nueva;

    public Moto(long serial, String marca, int precio, int cilindraje, boolean Nueva) {
        this.serial = serial;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.Nueva = Nueva;
    }

    public long getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public boolean isNueva() {
        return Nueva;
    }
}
