package com.Nomina.dominio;

public class Vendedor extends Directo{

    long ventasDelMes;
    private static final float MENOS_MINIMO = 0.045f;
    private static final float MAS_MINIMO = 0.035f;
    public Vendedor(String nombre, long salario,long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    @Override
    protected long calcularSalario() {
        return super.calcularSalario() + calcularComision();
    }
    @Override
    public String toString() {
        return getNombre()+" vendedor gana "+calcularSalario();
    }

    public long calcularComision() {
        if(getSalario() >= 1000000){
            return (long) (getSalario() * MAS_MINIMO);
        }
        return (long) (getSalario() * MENOS_MINIMO);

    }

}
