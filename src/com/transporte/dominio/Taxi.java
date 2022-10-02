package com.transporte.dominio;

public class Taxi extends Carro{
    private String empresa;
    private int nroPasajeros;

    public String getEmpresa() {
        return empresa;
    }

    public int getNroPasajeros() {
        return nroPasajeros;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setNroPasajeros(int nroPasajeros) {
        this.nroPasajeros = nroPasajeros;
    }
}
