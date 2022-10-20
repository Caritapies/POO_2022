package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Facturacion {
    private static final double IVA_19 = 0.19;
    private List<Factura> facturas;

    public Facturacion() {
        this.facturas = new ArrayList<>();
    }

    public void crearFactura(Persona persona, long valor) {
        Factura factura = null;

        if (persona.getNombre().toUpperCase().startsWith("A")) {
            factura = new FacturaSinIva(valor, persona);
        } else if (!(persona.getOcupacion().equalsIgnoreCase("desempleado"))){
            factura = new FacturaConDescuento(valor, persona);
        }
        else {
            factura = new FacturaConIVA(valor, persona, IVA_19);
        }
        this.facturas.add(factura);
    }
    public void crearFacturaVencida(Persona persona, long valor, int dia, int mes, int año){
        Factura factura = new FacturaVencida(valor,persona,dia,mes,año);
        this.facturas.add(factura);
    }


    public List<String> obtenerInfoFacturas(){
        return this.facturas.stream().map(fac -> {
            return "Factura #" + fac.numero + " a nombre de " + fac.persona.getNombre() + " - $" + fac.calcularTotal() + "\n";
        }).collect(Collectors.toList());
    }

    public double obtenerTotalFacturas() {
        return this.facturas.stream().mapToDouble(Factura::calcularTotal).sum();
    }
}
