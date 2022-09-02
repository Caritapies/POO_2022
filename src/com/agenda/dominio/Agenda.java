package com.agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Agenda {

        private static final int LIMITE_AGENDA = 50;
        public List<Contacto> contactos = new ArrayList<>();

        public boolean crearContacto(String nombre,String apellido,long numero){
            if(this.contactos.size() < LIMITE_AGENDA) {
                this.contactos.add(new Contacto(nombre, apellido, numero));
                return true;

            }
            return false;
        }
        public void eliminarContacto(long numero){
            contactos.remove(buscarContactoPorTelefono(numero));
        }
        public List<Contacto> buscarContactoPorNombre(String nombre){
            List<Contacto> nombres = new ArrayList<>();
            for(Contacto i: contactos){
                if(i.getNombre().equals(nombre)){
                    nombres.add(i);
                }
            }
            mostrarLista(nombres);
            return nombres;
        }
        public List<Contacto> buscarContactoPorApellido(String apellido){
            List<Contacto> apellidos = new ArrayList<>();
            for(Contacto i: contactos){
                if(i.getApellido().equals(apellido)){
                    apellidos.add(i);
                }
            }
            mostrarLista(apellidos);
            return apellidos;
        }
        public Contacto buscarContactoPorTelefono(long telefono){
            Contacto contactoBuscado = this.contactos.stream().filter(contacto -> contacto.getTelefono() == telefono).findFirst().orElse(null);
            return contactoBuscado;
        }
        public void cambiarTelefono(long numeroAntiguo,long numeroNuevo){
            if(numeroAntiguo == (buscarContactoPorTelefono(numeroAntiguo).getTelefono())){
                buscarContactoPorTelefono(numeroAntiguo).setTelefono(numeroNuevo);
            }
        }
        public void ordenarAlfabeticamente(){
            this.contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido))  ;
            System.out.print("Se ha ordenado la agenda en orden alfabetico.");

        }
        public void mostrarLista(List<Contacto> lista){
            for(Contacto contacto: lista){
                System.out.println(contacto.getNombre()+", "+contacto.getApellido()+", "+contacto.getTelefono());
            }
        }
    }


