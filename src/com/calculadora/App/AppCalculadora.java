package com.calculadora.App;

import com.calculadora.dominio.Calculadora;

import javax.swing.*;
import java.util.Objects;
import java.lang.Math;

public class AppCalculadora {

    public static void main(String[] args) {
        int eleccion;
        float numero1,numero2,resultado;
        JCheckBox checkbox = new JCheckBox("Redondear");
        boolean continuar = true;
        while(continuar){

            eleccion = JOptionPane.showOptionDialog(null,"alo","Calculadora",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, new Object[] {"Sumar", "Restar", "Multiplicar", "Dividir",checkbox},"Sumar");
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
