package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

public class FacturaSinIva extends Factura {
    public FacturaSinIva(double valor, Persona persona) {
        super(valor, persona);
    }

    @Override
    public double calcularTotal() {
        return super.valor;
    }
}
