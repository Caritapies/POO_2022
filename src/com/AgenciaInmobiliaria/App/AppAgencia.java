package com.AgenciaInmobiliaria.App;

import com.AgenciaInmobiliaria.dominio.Agencia;
import com.AgenciaInmobiliaria.dominio.Apartamento;
import com.AgenciaInmobiliaria.dominio.Casa;

public class AppAgencia {
    public static void main(String[] args) {
        Agencia agencia = new Agencia("San marcos");
        Casa casa = new Casa("San nicolas", 300000L,1000000);
        Apartamento apartamento = new Apartamento("Rionegro", 10000000L,1000000);
        agencia.agregarInmueble(apartamento);
        agencia.agregarInmueble(casa);
        agencia.arrendar(casa);
        System.out.println(agencia.getArrendados());
        System.out.println(agencia.getArrendablesDisponibles());


    }
}
