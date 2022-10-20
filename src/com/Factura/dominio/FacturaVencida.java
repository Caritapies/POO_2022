package com.Factura.dominio;

import com.ejerciciosRandom.farmacia.dominio.Persona;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class FacturaVencida extends Factura{
    private static final int VALOR_POR_DIA_VENCIDO = 1000;
    private final LocalDate fechaVencida;
    public FacturaVencida(double valor, Persona persona,int dia, int mes, int año) {
        super(valor, persona);
        fechaVencida = LocalDate.of(año,mes,dia);
    }
    @Override
    public double calcularTotal() {
        return Double.parseDouble(String.valueOf(valor + (long) diasVencidos()*VALOR_POR_DIA_VENCIDO));
    }
    public int diasVencidos() {
        return (int) DAYS.between(fechaVencida,fecha);
    }
}
