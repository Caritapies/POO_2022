package com.oftamologia.dominio;

import java.util.ArrayList;
import java.util.List;


public class Oftalmologo {
    private String nombre;
    private List<Paciente> pacientes;

    public Oftalmologo(String nombre) {
        this.nombre = nombre;
        pacientes = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public Paciente revisarPaciente(String nombre, int edad) {
        Paciente paciente = null;
        if(edad <= 40 && nombre.toLowerCase().startsWith("a")){
            paciente = new PacienteApto(nombre, edad, true);
        }else{
            paciente = new PacienteNoApto(nombre, edad, false);
        }
        return paciente;
    }
    public void agregarPaciente(Paciente paciente){
        this.pacientes.add(paciente);
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
    public void agregarALista(Paciente paciente){
        pacientes.add(paciente);
    }
}
