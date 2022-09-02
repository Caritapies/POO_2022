package com.agenda.App;

import com.agenda.dominio.Agenda;

import java.util.Scanner;

public class AppAgenda {

        public static void main(String[] args) {
            Agenda agenda1 = new Agenda();
            Scanner in = new Scanner(System.in);
            byte eleccion;
            String nombre,apellido;
            long telefono,telefonoNuevo;
            boolean activo = true;
            while(activo){
                System.out.println("Ingresa la opcion que quieras hacer :");
                System.out.println("1. Crear contacto    2. Eliminar contacto");
                System.out.println("3. Buscar contacto por nombre   4. Buscar contacto por apellido");
                System.out.println("5. Buscar contacto por telefono  6. Cambiar telefono");
                System.out.println("7. Ordenar lista alfabeticamente  8. Salir");
                eleccion = in.nextByte();

                switch (eleccion) {
                    case 1 -> {
                        System.out.print("nombre: ");
                        nombre = in.next();
                        System.out.print("apellido: ");
                        apellido = in.next();
                        System.out.print("telefono: ");
                        telefono = in.nextLong();
                        System.out.println(agenda1.crearContacto(nombre, apellido, telefono));
                    }
                    case 2 -> {
                        System.out.println("Ingresa el numero de quien quiere eliminar");
                        telefono = in.nextLong();
                        agenda1.eliminarContacto(telefono);
                    }
                    case 3 -> {
                        System.out.println("Ingresa el nombre del contacto ");
                        nombre = in.next();
                        agenda1.buscarContactoPorNombre(nombre);
                    }
                    case 4 -> {
                        System.out.println("Ingresa el apellido del contacto ");
                        apellido = in.next();
                        agenda1.buscarContactoPorApellido(apellido);
                    }
                    case 5 -> {
                        System.out.println("Ingresa el telefono del contacto ");
                        telefono = in.nextLong();
                        agenda1.buscarContactoPorTelefono(telefono);
                    }
                    case 6 -> {
                        System.out.println("Ingresa el telefono antiguo ");
                        telefono = in.nextLong();
                        System.out.println("Ingresa el telefono nuevo ");
                        telefonoNuevo = in.nextLong();
                        agenda1.cambiarTelefono(telefono, telefonoNuevo);
                    }
                    case 7 ->{
                        agenda1.ordenarAlfabeticamente();
                    }
                    case 8 ->{
                        activo = false;
                    }
                    case 9 ->{
                        agenda1.mostrarLista(agenda1.contactos);
                    }

                    default -> System.out.println("la elección está fuera de las opciones");
                }


            }
        }
    }

