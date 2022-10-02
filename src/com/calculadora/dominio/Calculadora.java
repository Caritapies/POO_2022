package com.calculadora.dominio;

import java.awt.*;
import javax.swing.*;
public class Calculadora {

    public static final int SUMAR = 0;
    public static final int RESTAR = 1;
    public static final int MULTIPLICAR= 2;
    public static final int DIVIDIR= 3;


    public static float sumar(float numero1, float numero2){
        return numero1 + numero2;
    }
    public static float restar(float numero1, float numero2){
        return numero1 - numero2;
    }
    public static float multiplicar(float numero1, float numero2){return numero1*numero2;}
    public static float dividir(float numero1,float numero2){return numero1/numero2;}

}
