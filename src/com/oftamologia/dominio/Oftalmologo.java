package com.oftamologia.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Oftalmologo {
    private String nombre;
    private List<Paciente> pacientes;

    public Oftalmologo(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public Paciente revisarPaciente(String nombre, int edad) {
        Paciente paciente = null;
        if(edad <= 40 && nombre.toLowerCase().startsWith("a")){
            paciente = new PacienteApto(nombre, edad, true);
        }else{
            new PacienteNoApto(nombre, edad, false);
        }
        return paciente;
    }
    public void operarPaciente(){
        pacientes.forEach(paciente ->{
            if(paciente instanceof PacienteApto){
                ((PacienteApto) paciente).operar();
            }
        });
    }
    public List<PacienteApto> getPacientesAOperar(){
        List<PacienteApto> pacientesAptos = new ArrayList<>();
        pacientes.forEach(paciente ->{
            if(paciente instanceof PacienteApto){
                pacientesAptos.add((PacienteApto) paciente);
            }
        });
        return pacientesAptos;
    }
}
