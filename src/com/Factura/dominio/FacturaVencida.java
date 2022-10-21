package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class FacturaVencida extends Factura{
    private int diasVencidos;
    private static final int VALOR_POR_DIA_VENCIDO = 1000;

    public FacturaVencida(double valor, Persona persona,int diasVencidos) {
        super(valor, persona);
        this.diasVencidos = diasVencidos;
    }
    @Override
    public double calcularTotal() {
        return Double.parseDouble(String.valueOf(valor + (long) diasVencidos*VALOR_POR_DIA_VENCIDO));
    }

}
