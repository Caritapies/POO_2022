package com.Factura.App;

import com.Factura.dominio.Factura;
import com.Factura.dominio.FacturaVencida;
import com.Factura.dominio.Facturacion;
import com.ejerciciosRandom.farmacia.dominio.Persona;

import javax.swing.*;

public class AppFacturacion {
    public static void main(String[] args) {
        int dia,mes,año,eleccion = 0;
        while (eleccion != -1) {
            eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de facturas", "Facturacion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"CrearFactura", "infoFacturas","pagarFacturas"}, "CrearFactura");
        }


    }
}
