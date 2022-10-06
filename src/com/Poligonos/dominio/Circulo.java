package com.Poligonos.dominio;

public class Circulo extends FiguraGeometrica {
    private int radio;

    @Override
    public float area() {
        return (float)Math.PI*radio*radio;
    }

    @Override
    public float perimetro() {
        return (float) (2*Math.PI*radio);
    }
}
