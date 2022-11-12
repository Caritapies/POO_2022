package com.AgenciaInmobiliaria.dominio;

public class Apartamento extends Inmueble implements Arrendable{
    public Apartamento(String direccion, Long valorVenta, int valorArriendo) {
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
        return "El apartamento ubicado en "+getDireccion()+" tiene un valor de "+getValorVenta()+" y se arrienda en "+getValorArriendo();
    }
}
