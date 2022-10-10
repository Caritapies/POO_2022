package com.FigurasGeometricas.dominio;

public class Cuadrado extends FiguraGeometrica {
    private float lado;

    @Override
    public float area() {
        return lado*lado;
    }

    @Override
    public float perimetro() {
        return 4*lado;
    }
}
