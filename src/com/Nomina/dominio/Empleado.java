package com.Nomina.dominio;

public abstract class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    protected abstract long calcularSalario();

    public String getNombre() {
        return nombre;
    }
}
