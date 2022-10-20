package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

public class FacturaConDescuento extends Factura {
    private static final float DESCUENTO_ESTUDIANTE = (float) 0.1;
    private static final float DESCUENTO_TRABAJADOR = (float) 0.2;
    private static final float DESCUENTO_INDEPENDIENTE = (float) 0.3;

    public FacturaConDescuento(double valor, Persona persona) {
        super(valor, persona);
    }

    @Override
    public double calcularTotal() {
        if (persona.getOcupacion().equalsIgnoreCase("estudiante")) {
            return super.valor - (valor * DESCUENTO_ESTUDIANTE);
        }else if(persona.getOcupacion().equalsIgnoreCase("trabajador")){
            return super.valor - (valor * DESCUENTO_TRABAJADOR);
        }else if(persona.getOcupacion().equalsIgnoreCase("independente")){
            return super.valor - (valor * DESCUENTO_INDEPENDIENTE);
        }
        return super.valor;
    }
}
