package com.Factura.App;

import com.Factura.dominio.Facturacion;
import com.ejerciciosRandom.farmacia.dominio.Persona;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppFacturacion {
    private static final int CREAR_FACTURA = 0;
    private static final int MOSTRAR_FACTURAS = 1;
    private static final int TOTAL_FACTURAS = 2;
    public static void main(String[] args) {
        Facturacion sistemaFac = new Facturacion();
        byte eleccion;
        String nombre, ocupacion;
        List<String> opciones = Arrays.asList("Crear Factura", "Info Facturas", "Valor total Facturas");

        boolean facturando = true;
        while (facturando){
            eleccion = (byte) JOptionPane.showOptionDialog(null, "Sistema de facturacion", "Sistema de Facturacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones.toArray(),"Crear Factura");
            switch (eleccion) {
                case JOptionPane.CLOSED_OPTION -> facturando = false;
                case CREAR_FACTURA -> {

                    nombre = (String) JOptionPane.showInputDialog(null, "¿A nombre de quién va la factura?", "Ingreso de datos", JOptionPane.ERROR_MESSAGE, null, null, "Nombre");
                    ocupacion = (String) JOptionPane.showInputDialog(null, "Ingrese la ocupación de "+nombre+" \n(Si es ninguna ingrese desempleado)", "Ingreso de datos", JOptionPane.INFORMATION_MESSAGE, null, null, "Ocupacion");
                    Persona persona = new Persona(nombre, ocupacion);

                    double valor = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingrese el valor de la factura", "Ingreso de datos", JOptionPane.ERROR_MESSAGE, null, null, 0));
                    JOptionPane.showMessageDialog(null, "Ingrese la fecha");

                    int año = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el año", "fecha", JOptionPane.INFORMATION_MESSAGE, null, null, 0));
                    int mes = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el mes", "fecha", JOptionPane.INFORMATION_MESSAGE, null, null, 0));
                    int dia = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese el dia", "fecha", JOptionPane.INFORMATION_MESSAGE, null, null, 0));

                    LocalDate fecha = LocalDate.of(año, mes, dia);
                    sistemaFac.crearFactura(persona, valor, fecha);
                }
                case MOSTRAR_FACTURAS -> JOptionPane.showMessageDialog(null, sistemaFac.obtenerInfoFacturas());
                case TOTAL_FACTURAS -> JOptionPane.showMessageDialog(null, "El valor actual de las facturas es\n"+sistemaFac.obtenerTotalFacturas());
            }
        }
    }
}
