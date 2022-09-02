package com.dispensador.App;

import com.dispensador.dominio.Dispensador;


public class AppDispensador {
    public static void main(String[] args) {
        Dispensador dispensador = new Dispensador();
        dispensador.agregarSnack("margarita");
        dispensador.agregarSnack("pollo");
        System.out.println(dispensador.aumentarCantidad("pollo"));
    }
}

