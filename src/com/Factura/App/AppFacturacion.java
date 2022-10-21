package com.Factura.App;

import com.Factura.dominio.Factura;
import com.Factura.dominio.FacturaVencida;
import com.Factura.dominio.Facturacion;
import com.ejerciciosRandom.farmacia.dominio.Persona;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AppFacturacion {
    public static void main(String[] args) {
        Facturacion sistemaFac = new Facturacion();
        byte opcionSeleccionada ;
        List<String> opcionCrearInfoValor = Arrays.asList("Crear Factura", "Info Facturas", "Valor total Facutras");

        boolean facturando = true;
        while (facturando){
            opcionSeleccionada = (byte) JOptionPane.showOptionDialog(null, "Sistema de facturacion", "Sistema de Facturacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcionCrearInfoValor.toArray(),"Crear Factura");
            switch (opcionSeleccionada) {
                case -1 -> facturando = false;
                case 0 -> {
                    String nombre = (String) JOptionPane.showInputDialog(null, "¿A nombre de quién va la factura?", "Ingreso de datos", JOptionPane.YES_NO_OPTION, null, null, "Nombre");
                    Persona propietario = new Persona(nombre);
                    double valor = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese el valor de la factura", "Ingreso de datos", JOptionPane.YES_NO_OPTION, null, null, 0));
                    JOptionPane.showMessageDialog(null, "Ingrese la fecha");
                    int año = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el año", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    int mes = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el mes", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    int dia = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el dia", "Ingreso de fecha", JOptionPane.YES_NO_OPTION, null, null, 0));
                    LocalDate fecha = LocalDate.of(año, mes, dia);
                    sistemaFac.crearFactura(propietario, valor, fecha);
                }
                case 1 -> JOptionPane.showMessageDialog(null, sistemaFac.obtenerInfoFacturas());
                case 2 -> JOptionPane.showMessageDialog(null, "El valor actual de las facturas es\n"+sistemaFac.obtenerTotalFacturas());
            }
        }
    }
}
