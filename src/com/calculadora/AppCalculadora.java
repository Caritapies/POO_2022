package com.calculadora;

import javax.swing.*;
import java.lang.Math;

public class AppCalculadora {
    private static final ImageIcon ICONO = new ImageIcon(AppCalculadora.class.getResource("calculator.png"));
    private static final ImageIcon SUMAR = new ImageIcon(AppCalculadora.class.getResource("add.png"));
    private static final ImageIcon RESTAR = new ImageIcon(AppCalculadora.class.getResource("Substract.png"));
    private static final ImageIcon MULTIPLICAR = new ImageIcon(AppCalculadora.class.getResource("multiply.png"));
    private static final ImageIcon DIVIDIR = new ImageIcon(AppCalculadora.class.getResource("divide.png"));

    public static void main(String[] args) {


        int eleccion;
        float numero1,numero2,resultado;
        JCheckBox checkbox = new JCheckBox("Redondear");
        boolean continuar = true;
        while(continuar){

            eleccion = JOptionPane.showOptionDialog(null,"","Calculadora",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,ICONO, new Object[] {SUMAR, RESTAR, MULTIPLICAR, DIVIDIR,checkbox},"");
            switch (eleccion){
                case Calculadora.SUMAR -> {
                    numero1 = Float.parseFloat(JOptionPane.showInputDialog("Numero 1"));
                    numero2 = Float.parseFloat(JOptionPane.showInputDialog("Numero 2"));
                    resultado = Calculadora.sumar(numero1,numero2);
                    if(checkbox.isSelected())
                        JOptionPane.showMessageDialog(null,Math.round(resultado));
                    else{
                        JOptionPane.showMessageDialog(null,resultado);
                    }
                }
                case Calculadora.RESTAR -> {
                    numero1 = Float.parseFloat(JOptionPane.showInputDialog("Numero 1"));
                    numero2 = Float.parseFloat(JOptionPane.showInputDialog("Numero 2"));
                    resultado = Calculadora.restar(numero1,numero2);
                    if(checkbox.isSelected())
                        JOptionPane.showMessageDialog(null,Math.round(resultado));
                    else{
                        JOptionPane.showMessageDialog(null,resultado);
                    }
                }
                case Calculadora.MULTIPLICAR -> {
                    numero1 = Float.parseFloat(JOptionPane.showInputDialog("Numero 1"));
                    numero2 = Float.parseFloat(JOptionPane.showInputDialog("Numero 2"));
                    resultado = Calculadora.multiplicar(numero1,numero2);
                    if(checkbox.isSelected())
                        JOptionPane.showMessageDialog(null,Math.round(resultado));
                    else{
                        JOptionPane.showMessageDialog(null,resultado);
                    }
                }
                case Calculadora.DIVIDIR -> {
                    numero1 = Float.parseFloat(JOptionPane.showInputDialog("Numero 1"));
                    numero2 = Float.parseFloat(JOptionPane.showInputDialog("Numero 2"));
                    resultado = Calculadora.dividir(numero1,numero2);
                    if(checkbox.isSelected())
                        JOptionPane.showMessageDialog(null,Math.round(resultado));
                    else{
                        JOptionPane.showMessageDialog(null,resultado);
                    }
                }
                case JOptionPane.DEFAULT_OPTION -> {
                    continuar = false;
                }
            }

        }

    }
}
