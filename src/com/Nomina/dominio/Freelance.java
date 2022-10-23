package com.Nomina.dominio;

public class Freelance extends Empleado{
    long valorHora;
    int horasTrabajadas;

    public Freelance(String nombre,long valorHora,int horasTrabajadas) {
        super(nombre);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    protected long calcularSalario() {
        return horasTrabajadas * valorHora;
    }
    @Override
    public String toString() {
        return getNombre()+" empleado freelance gana "+calcularSalario();
    }



}
