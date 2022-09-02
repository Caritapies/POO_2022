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
        return true;

    }
    public boolean sacarSnack(byte codigo){
        for(Mekato i: mekato){

            if(i.getCodigo() == codigo && i.getCantidad() != 0){
                i.setCantidad(i.getCantidad() - 1);
                return true;
            }
        }
        return false;
    }
    public boolean sacarSnack(String nombre){

        for(Mekato i: mekato){

            if(i.getNombre().equals(nombre) && i.getCantidad() != 0){

                i.setCantidad(i.getCantidad() - 1);
                return true;
            }
        }
        return false;
    }
    public boolean aumentarCantidad(String nombre){
        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre) && i.getCantidad() < 6){
                i.setCantidad(i.getCantidad()+1);
                return true;
            }
        }
        return false;
    }
    public boolean quitarSnack(String nombre){
        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre) && i.getCantidad() > 0){
                mekato.remove(i);
                return true;
            }
        }
        return false;
    }
    public int obtenerCantidadSnack(String nombre){

        for(Mekato i: mekato){
            if(i.getNombre().equals(nombre)){
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
        return agotados;
    }
    public List<String> obtenerNombreActivos(){

        List<String> activos = new ArrayList<>();
        for(Mekato i: mekato){
            if(i.getCantidad() != 0){
                activos.add(i.getNombre());
            }
        }
        return activos;

    }
    public List<Mekato> obtenerValorMayorAMenor() {
        List<Mekato> ordenada = mekato;
        ordenada.sort(Comparator.comparing(Mekato::getValor).reversed());
        return ordenada;
    }

    public List<Mekato> obtenerCantidadMenorAMayor() {
        List<Mekato> ordenada = mekato;
        ordenada.sort(Comparator.comparing(Mekato::getCantidad));
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
}



