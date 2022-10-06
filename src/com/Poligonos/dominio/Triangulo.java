package com.Poligonos.dominio;

public class Triangulo extends FiguraGeometrica {
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
}
