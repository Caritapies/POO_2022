package com.AgenciaInmobiliaria.dominio;

public class Lote extends Inmueble{
    public Lote(String direccion, Long valorVenta, int valorArriendo) {
        super(direccion, valorVenta, valorArriendo);
    }
    @Override
    public String toString() {
        return "El lote ubicado en "+getDireccion()+" tiene un valor de "+getValorVenta();
    }
}
