package com.dispensador.App;

import com.dispensador.dominio.Dispensador;

import java.util.Scanner;


public class AppDispensador {
    public static void main(String[] args) {

        Dispensador dispensador = new Dispensador();
        Scanner in = new Scanner(System.in);
        byte eleccion,codigo;
        int valor;
        String nombre;

        boolean activo = true;
        while(activo){
            System.out.println("Ingresa la opcion que quieras hacer :");
            System.out.println("1. Agregar Snack    2. Sacar Snack(nombre)");
            System.out.println("3. Sacar Snack(codigo)   4. Aumentar cantidad");
            System.out.println("5. Quitar Snack  6. Obtener cantidad Snack");
            System.out.println("7. Obtener nombre agotados  8. Obtener nombre activos");
            System.out.println("9. Obtener valor mayor a menor  10. Obtener valor menor a mayor");
            System.out.println("11. Validar existencia Snack  12. Salir");
            eleccion = in.nextByte();

            switch (eleccion) {
                case 1 -> {
                    System.out.print("nombre: ");
                    nombre = in.next();
                    System.out.print("precio: ");
                    valor = in.nextInt();
                    dispensador.agregarSnack(nombre,valor);
                    dispensador.mostrarLista();
                }
                case 2 -> {
                    System.out.println("Ingresa el nombre del snack que quiere sacar ");
                    nombre = in.next();
                    dispensador.sacarSnack(nombre);
                    dispensador.mostrarLista();
                }
                case 3 -> {
                    System.out.println("Ingresa el codigo del snack que quiere sacar ");
                    codigo = in.nextByte();
                    dispensador.sacarSnack(codigo);
                    dispensador.mostrarLista();
                }
                case 4 -> {
                    System.out.println("Ingresa el nombre del snack que quiere aumentar su cantidad ");
                    nombre = in.next();
                    dispensador.aumentarCantidad(nombre);
                    dispensador.mostrarLista();
                }
                case 5 -> {
                    System.out.println("Ingresa el Snack que quiere eliminar ");
                    nombre = in.next();
                    dispensador.quitarSnack(nombre);
                }
                case 6 -> {
                    System.out.println("Ingresa nombre Snack ");
                    nombre = in.next();
                    dispensador.obtenerCantidadSnack(nombre);

                }
                case 7 ->{
                    dispensador.obtenerNombreAgotados();
                }
                case 8 ->{
                    dispensador.obtenerNombreActivos();
                }
                case 9 ->{
                    dispensador.obtenerValorMayorAMenor();
                }
                case 10 ->{
                    dispensador.obtenerCantidadMenorAMayor();
                }
                case 11 ->{

                    System.out.println("Ingresa el nombre del snack que quiere validar ");
                    nombre = in.next();
                    dispensador.validarExistenciaSnack(nombre);
                }
                case 12->{
                    activo = false;
                }
                default -> System.out.println("la elección está fuera de las opciones");
            }

            }
    }
}

