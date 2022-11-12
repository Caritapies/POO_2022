package com.AgenciaInmobiliaria.dominio;

public class Casa extends Inmueble implements Arrendable {
    public Casa(String direccion, Long valorVenta, int valorArriendo) {
        super(direccion, valorVenta, valorArriendo);
    }
    @Override
    public void arrendar() {
        setArrendado(true);
    }
    @Override
    public void devolver() {
        setArrendado(false);
    }

    @Override
    public String toString() {
        return "La casa ubicada en "+getDireccion()+" tiene un valor de "+getValorVenta()+" y se arrienda en "+getValorArriendo();
    }
}
