package com.FigurasGeometricas.dominio;

public class TrianguloEquilatero extends Triangulo{
    private float base;
    private float altura;

    @Override
    public float area() {
        return (base*altura)/2;
    }

    @Override
    public float perimetro() {
        return 3*base;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
