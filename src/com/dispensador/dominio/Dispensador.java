package com.dispensador.dominio;

import java.util.ArrayList;
import java.util.List;


public class Dispensador {
    List<Mekato> mekato = new ArrayList<>();
    private final static int LIMITE_SNACK = 12;

    public boolean agregarSnack(String nombre){
        Mekato snack = new Mekato(nombre,this.mekato.size() + 1);
        for(Mekato i: mekato){
            if((i.getNombre().equals(nombre)) || mekato.size() > LIMITE_SNACK) {
                return false;
            }
        }
        this.mekato.add(snack);
        snack.setCantidad(1);
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
    public int obtenerCantidadSnack(Mekato snack){

        if(mekato.contains(snack)){
            return snack.getCantidad();
        }
        return 0;
    }
    public List<Mekato> obtenerNombreAgotados(){
        List<Mekato> agotados = new ArrayList<>();
        for(Mekato i: mekato){
            if(i.getCantidad() == 0){
                agotados.add(i);
            }
        }
        return agotados;
    }
    public List<Mekato> obtenerNombreActivos(){

        List<Mekato> activos = new ArrayList<>();
        for(Mekato i: mekato){
            if(i.getCantidad() != 0){
                activos.add(i);
            }
        }
        return activos;

    }
    public void ordenSnackValorMayor(){




    }
    public void ordenSnackValorMenor(){

    }
    public boolean validarExistenciaSnack(Mekato snack){
        return mekato.contains(snack);
    }
}

