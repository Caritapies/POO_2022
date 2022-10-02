package com.ejerciciosRandom.concesionario.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Concesionario {

    public final int CAPACIDAD_TOTAL = 15;
    private String nombre;
    List<Moto> motos = new ArrayList<>();

    public Concesionario(String nombre) {
        this.nombre = nombre;
    }
    public boolean ingresar(Moto moto){
        if(motos.size() >= CAPACIDAD_TOTAL && diferenteSerial(moto)){
            motos.add(moto);
            return true;
        }
        return false;
    }
    public boolean diferenteSerial(Moto moto){
        for(Moto i: motos){
            if(i.getSerial() == moto.getSerial()){
                return false;
            }
        }
        return true;
    }
    public Moto buscar(long serial){
        return this.motos.stream().filter(moto -> moto.getSerial()==serial).findFirst().orElse(null);
    }
    public List<Moto> buscar(String marca){
        return this.motos.stream().filter(c -> c.getMarca().equalsIgnoreCase(marca)).collect(Collectors.toList());
    }
    public List<Moto> buscar(boolean soloNuevas){
        return this.motos.stream().filter(Moto::isNueva).collect(Collectors.toList());
    }
    public List<Moto> buscarQueTendanMasDe(int cilindraje){
        return this.motos.stream().filter(c-> c.getCilindraje() < cilindraje).collect(Collectors.toList());
    }
    public void vender(Moto moto){
        this.motos.remove(moto);
    }

    public int getCapacidad_Restante() {
        return CAPACIDAD_TOTAL-motos.size();
    }
}
