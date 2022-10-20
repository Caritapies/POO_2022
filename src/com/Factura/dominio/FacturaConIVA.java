package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

public class FacturaConIVA extends Factura {
    private double iva;

    public FacturaConIVA(double valor, Persona persona, double iva) {
        super(valor, persona);
        this.iva = iva;
    }

    @Override
    public double calcularTotal() {
        return super.valor + this.calcularIva();
    }

    public double calcularIva() {
        return super.valor * this.iva;
    }
}

