package com.dispensador.dominio;

import com.agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Dispensador {
    List<Mekato> mekato = new ArrayList<>();
    private final static int LIMITE_SNACK = 12,LIMITE_UNIDAD = 6;

    public boolean agregarSnack(String nombre,int valor){
        Mekato snack = new Mekato(nombre,this.mekato.size() + 1,valor);
        for(Mekato i: mekato){
            if((i.getNombre().equals(nombre)) || mekato.size() > LIMITE_SNACK || i.getCantidad() > LIMITE_UNIDAD) {
                return false;
            }
        }
        this.mekato.add(snack);
        snack.setCantidad(LIMITE_UNIDAD);
        mostrarLista(this.mekato);
        return true;

    }
    public boolean sacarSnack(byte codigo){
        for(Mekato i: mekato){

            if(i.getCodigo() == codigo && i.getCantidad() != 0){
                i.setCantidad(i.getCantidad() - 1);
                mostrarLista(this.mekato);
                return true;
            }
        }
        return false;
    }
    public boolean sacarSnack(String nombre){

        for(Mekato i: mekato){

            if(i.getNombre().equals(nombre) && i.getCantidad() != 0){

                i.setCantidad(i.getCantidad() - 1);
                mostrarLista(this.mekato);
                return true;
            }
        }
        return false;
    }
    public boolean aumentarCantidad(String nombre){
        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre) && i.getCantidad() < LIMITE_UNIDAD){
                i.setCantidad(i.getCantidad()+1);
                mostrarLista(this.mekato);
                return true;
            }
        }
        return false;
    }
    public boolean quitarSnack(String nombre){
        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre) && i.getCantidad() > 0){
                mekato.remove(i);
                mostrarLista(this.mekato);
                return true;
            }
        }
        return false;
    }
    public int obtenerCantidadSnack(String nombre){

        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre)){
                System.out.println(i.getCantidad());
                return i.getCantidad();
            }
        }
        return 0;
    }
    public List<String> obtenerNombreAgotados(){
        List<String> agotados = new ArrayList<>();
        for(Mekato i: mekato){
            if(i.getCantidad() == 0){
                agotados.add(i.getNombre());
            }
        }
        mostrarListaString(agotados);
        return agotados;
    }
    public List<String> obtenerNombreActivos(){

        List<String> activos = new ArrayList<>();
        for(Mekato i: mekato){
            if(i.getCantidad() != 0){
                activos.add(i.getNombre());
            }
        }
        mostrarListaString(activos);
        return activos;

    }
    public List<Mekato> obtenerValorMayorAMenor() {
        List<Mekato> ordenada = mekato;
        ordenada.sort(Comparator.comparing(Mekato::getValor).reversed());
        mostrarLista(ordenada);
        return ordenada;
    }

    public List<Mekato> obtenerCantidadMenorAMayor() {
        List<Mekato> ordenada = mekato;
        ordenada.sort(Comparator.comparing(Mekato::getCantidad));
        mostrarLista(ordenada);
        return ordenada;
    }
    public boolean validarExistenciaSnack(String nombre){
        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre) && i.getCantidad() > 0){
                return true;
            }
        }
        return false;

    }
    public void mostrarLista(List<Mekato> lista){
        for(Mekato snack: lista){
            System.out.println(snack.getNombre()+", cantidad: "+snack.getCantidad()+", codigo: "+snack.getCodigo()+
                    ", valor: "+snack.getValor());
        }
    }
    public void mostrarListaString(List<String> lista){
        for(String snack: lista){
            System.out.println(snack);
        }
    }

    public List<Mekato> getMekato() {
        return mekato;
    }
}



