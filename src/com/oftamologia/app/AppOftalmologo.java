package com.oftamologia.app;

import com.oftamologia.dominio.Oftalmologo;
import com.oftamologia.dominio.PacienteApto;

import java.util.List;

public class AppOftalmologo {
    public static void main(String[] args) {
        Oftalmologo oftalmologo = new Oftalmologo("pedro");

        oftalmologo.agregarPaciente(oftalmologo.revisarPaciente("anuel",40));
        oftalmologo.agregarPaciente(oftalmologo.revisarPaciente("Si",23));
        oftalmologo.agregarPaciente(oftalmologo.revisarPaciente("hola",87));

        mostrarLista(oftalmologo.getPacientesAOperar());
        oftalmologo.operarPaciente();
    }
    public static void mostrarLista(List<PacienteApto> lista){
        lista.forEach(paciente -> System.out.println(paciente.getNombre()));
    }

}
