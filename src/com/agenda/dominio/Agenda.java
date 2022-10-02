package com.agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Agenda {

        private static final int LIMITE_AGENDA = 50;
        public List<Contacto> contactos = new ArrayList<>();

        public boolean crearContacto(String nombre,String apellido,long numero){
            if(this.contactos.size() < LIMITE_AGENDA && buscarContactoPorTelefono(numero) == null) {
                this.contactos.add(new Contacto(nombre, apellido, numero));
                return true;

            }
            return false;
        }
        public void eliminarContacto(long numero){
            contactos.remove(buscarContactoPorTelefono(numero));
        }
        public List<Contacto> buscarContactoPorNombre(String nombre){
            return this.contactos.stream().filter(c -> c.getNombre().toLowerCase().startsWith(nombre.toLowerCase()))
                    .collect(Collectors.toList());
        }
        public List<Contacto> buscarContactoPorApellido(String apellido){
            return this.contactos.stream().filter(c -> c.getApellido().toLowerCase().startsWith(apellido.toLowerCase()))
                    .collect(Collectors.toList());
        }
        public Contacto buscarContactoPorTelefono(long telefono){
            Contacto contactoBuscado = this.contactos.stream().filter(contacto -> contacto.getTelefono() == telefono).findFirst().orElse(null);
            return contactoBuscado;
        }
        public boolean cambiarTelefono(long numeroAntiguo,long numeroNuevo){
            if(numeroAntiguo == (buscarContactoPorTelefono(numeroAntiguo).getTelefono())){
                buscarContactoPorTelefono(numeroAntiguo).setTelefono(numeroNuevo);
            }
            return false;
        }
        public void ordenarAlfabeticamente(){
            this.contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido))  ;
            System.out.println("Se ha ordenado la agenda en orden alfabetico.");
            mostrarLista(contactos);

        }
        public void mostrarLista(List<Contacto> lista){
            for(Contacto contacto: lista){
                System.out.println(contacto.getNombre()+", "+contacto.getApellido()+", "+contacto.getTelefono());
            }
        }
    }


