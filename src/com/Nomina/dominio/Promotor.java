package com.Nomina.dominio;

public class Promotor extends Empleado{
    private int volantesRepartidos;
    private long valorVolante;
    private int comprasVolantes;
    private final int VALOR_COMPRA = 15000;

    public Promotor(String nombre,int volantesRepartidos,int comprasVolantes,long valorVolante) {
        super(nombre);
        this.volantesRepartidos = volantesRepartidos;
        this.valorVolante = valorVolante;
        this.comprasVolantes = comprasVolantes;
    }
    @Override
    public String toString() {
        return getNombre()+" empleado promotor gana "+calcularSalario()+"\n";
    }

    public int calcularCompras(){
        return comprasVolantes*VALOR_COMPRA;
    }
    @Override
    protected long calcularSalario() {
        return valorVolante*volantesRepartidos + calcularCompras();
    }
}
