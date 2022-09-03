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
            System.out.println("Ingresa la opcion que quieras hacer :\n" +
                    "1. Agregar Snack    2. Sacar Snack(nombre)\n" +
                    "3. Sacar Snack(codigo)   4. Aumentar cantidad\n" +
                    "5. Quitar Snack  6. Obtener cantidad Snack\n" +
                    "7. Obtener nombre agotados  8. Obtener nombre activos\n" +
                    "9. Obtener valor mayor a menor  10. Obtener cantidad menor a mayor\n" +
                    "11. Validar existencia Snack  12. Salir");

            eleccion = in.nextByte();

            switch (eleccion) {
                case 1 -> {
                    System.out.print("nombre: ");
                    nombre = in.next();
                    System.out.print("precio: ");
                    valor = in.nextInt();
                    dispensador.agregarSnack(nombre,valor);
                }
                case 2 -> {
                    System.out.println("Ingresa el nombre del snack que quiere sacar ");
                    nombre = in.next();
                    dispensador.sacarSnack(nombre);
                }
                case 3 -> {
                    System.out.println("Ingresa el codigo del snack que quiere sacar ");
                    codigo = in.nextByte();
                    dispensador.sacarSnack(codigo);

                }
                case 4 -> {
                    System.out.println("Ingresa el nombre del snack que quiere aumentar su cantidad ");
                    nombre = in.next();
                    dispensador.aumentarCantidad(nombre);

                }
                case 5 -> {
                    System.out.println("Ingresa el Snack que quiere eliminar ");
                    nombre = in.next();
                    dispensador.quitarSnack(nombre);
                }
                case 6 -> {
                    System.out.println("Ingresa nombre Snack ");
                    nombre = in.next();
                    System.out.println(dispensador.obtenerCantidadSnack(nombre));

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
                    System.out.println(dispensador.validarExistenciaSnack(nombre));
                }
                case 12->{
                    activo = false;
                }
                default -> System.out.println("la elección está fuera de las opciones");
            }


            }
    }
}

