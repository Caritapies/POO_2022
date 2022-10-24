package com.Nomina.App;

import com.Nomina.dominio.*;

import javax.swing.*;


public class AppNomina {
    public static void main(String[] args) {
        int eleccion,horasTrabajadas,valorHora,ventasDelMes;
        int volantesRepartidos,comprasVolante;
        long valorVolante;
        long salario;
        String nombre, tipoEmpleado;
        Empleado empleado;
        Object[] opciones = new Object[]{"Agregar Empleado","Mostrar Nomina","Listar Directos", "Listar Freelancers","Listar Promotores"};
        Nomina nomina = new Nomina();
        do{
            eleccion = JOptionPane.showOptionDialog(null, "Sistema de nómina", "Nomina de empleados", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opciones,null);
            switch (eleccion){
                case 0->{
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                    tipoEmpleado = JOptionPane.showInputDialog("Ingrese el tipo de contrato tiene?\n Directo,Freelance,Vendedor,Promotor");
                    switch (tipoEmpleado.toLowerCase()){
                        case "directo"->{
                            salario = Long.parseLong(JOptionPane.showInputDialog("Ingrese el salario"));
                            empleado = new Directo(nombre,salario);
                            nomina.añadirEmpleado(empleado);
                        }
                        case "freelance"->{
                            horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas"));
                            valorHora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la hora"));
                            empleado = new Freelance(nombre,valorHora,horasTrabajadas);
                            nomina.añadirEmpleado(empleado);
                        }case "vendedor"->{
                            salario = Long.parseLong(JOptionPane.showInputDialog("Ingrese el salario"));
                            ventasDelMes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ventas del mes"));
                            empleado = new Vendedor(nombre,salario,ventasDelMes);
                            nomina.añadirEmpleado(empleado);
                        }case "promotor"->{
                            valorVolante = Long.parseLong(JOptionPane.showInputDialog("Ingrese el valor al que reparte el volante"));
                            volantesRepartidos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los volantes repartidos"));
                            comprasVolante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de volantes que compraron"));
                            empleado = new Promotor(nombre,volantesRepartidos,comprasVolante,valorVolante);
                            nomina.añadirEmpleado(empleado);
                        }

                    }
                }
                case 1->
                    JOptionPane.showMessageDialog(null,nomina.calcularNomina());
                case 2->
                    JOptionPane.showMessageDialog(null,nomina.listarDirectos());
                case 3->
                    JOptionPane.showMessageDialog(null,nomina.listarFreelancer());
                case 4->{
                    JOptionPane.showMessageDialog(null,nomina.listarPromotores());
                }
            }
        }while(eleccion != -1);
    }
}
