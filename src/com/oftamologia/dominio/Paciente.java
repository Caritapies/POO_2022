package com.oftamologia.dominio;

public abstract class Paciente {
    String nombre;
    int edad;
    boolean necesitaCirugia;
    public Paciente(String nombre, int edad, boolean necesitaCirugia){
        this.nombre = nombre;
        this.edad = edad;
        this.necesitaCirugia = necesitaCirugia;
    }
}
