package com.AgenciaInmobiliaria.dominio;

public abstract class Inmueble {
    private String direccion;
    private Long valorVenta;
    private int valorArriendo;
    private boolean arrendado;

    public Inmueble(String direccion, Long valorVenta, int valorArriendo){
        this.direccion = direccion;
        this.valorVenta = valorVenta;
        this.valorArriendo = valorArriendo;
        this.arrendado = false;
    }

    public void setArrendado(boolean arrendado) {
        this.arrendado = arrendado;
    }
    public boolean isArrendado() {return arrendado;}

    public String getDireccion() {
        return direccion;
    }

    public Long getValorVenta() {
        return valorVenta;
    }

    public int getValorArriendo() {
        return valorArriendo;
    }
}
