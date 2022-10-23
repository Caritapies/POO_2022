package com.Nomina.App;

import com.Nomina.dominio.*;

import javax.swing.*;


public class AppNomina {
    public static void main(String[] args) {
        int eleccion,horasTrabajadas,valorHora,ventasDelMes;
        long salario;
        String nombre, tipoEmpleado;
        Empleado empleado;
        Object[] opciones = new Object[]{"Agregar Empleado","Mostrar Nomina","Listar Directos", "Listar Freelancers"};
        Nomina nomina = new Nomina();
        do{
            eleccion = JOptionPane.showOptionDialog(null, "", "Nomina de empleados", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opciones,null);
            switch (eleccion){
                case 0->{
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
                    tipoEmpleado = JOptionPane.showInputDialog("Ingrese el tipo de contrato tiene?\n Directo,Freelance,Vendedor");
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
                        }

                    }
                }
                case 1->
                    JOptionPane.showMessageDialog(null,nomina.calcularNomina());

                case 2->
                    JOptionPane.showMessageDialog(null,nomina.listarDirectos());
                case 3->
                    JOptionPane.showMessageDialog(null,nomina.listarFreelancer());
            }
        }while(eleccion != -1);
    }
}
