package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class Facturacion {
    private static final double IVA_19 = 0.19;
    private List<Factura> facturas;

    public Facturacion() {
        this.facturas = new ArrayList<>();
    }

    public void crearFactura(Persona persona, double valor, LocalDate fecha) {
        Factura factura = null;

        if(diasVencidos(fecha,LocalDate.now()) != 0 ){
            factura = new FacturaVencida(valor, persona,diasVencidos(fecha,LocalDate.now()));
        } else if (!(persona.getOcupacion().equalsIgnoreCase("desempleado"))){
            factura = new FacturaConDescuento(valor, persona);
        }
        else {
            factura = new FacturaConIVA(valor, persona, IVA_19);
        }
        this.facturas.add(factura);
    }
    public static int diasVencidos(LocalDate fechaVencida, LocalDate fecha) {
        return (int) DAYS.between(fechaVencida,fecha);
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
