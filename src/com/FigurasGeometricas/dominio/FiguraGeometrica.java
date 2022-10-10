package com.FigurasGeometricas.dominio;

public abstract class FiguraGeometrica {
    protected int numeroLados;
    protected int numeroVertices;

    public abstract float area();
    public abstract float perimetro();
}
