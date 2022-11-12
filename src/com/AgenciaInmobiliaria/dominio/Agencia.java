package com.AgenciaInmobiliaria.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    private String nombre;
    private List<Inmueble> inmuebles;

    public Agencia(String nombre) {
        this.nombre = nombre;
        inmuebles = new ArrayList<>();
    }

    public void agregarInmueble(Inmueble inmueble) {
        this.inmuebles.add(inmueble);
    }
    public boolean arrendar(Arrendable inmueble){
        if(inmueble instanceof Inmueble && !((Inmueble) inmueble).isArrendado()){
            inmueble.arrendar();
            return true;
        }
        return false;
    }
    public boolean devolver(Arrendable inmueble){
        if(inmueble instanceof Inmueble && ((Inmueble) inmueble).isArrendado()){
            inmueble.devolver();
            return true;
        }
        return false;
    }
    public boolean vender(Inmueble inmueble){
        if (!inmueble.isArrendado()){
            inmuebles.remove(inmueble);
            return true;
        }
        return false;
    }
    public List<Inmueble> getArrendablesDisponibles(){
        return inmuebles.stream().filter(c -> !c.isArrendado() && c instanceof Arrendable).collect(Collectors.toList());
    }
    public List<Inmueble> getArrendados(){
        return inmuebles.stream().filter(c -> c.isArrendado() && c instanceof Arrendable).collect(Collectors.toList());
    }
    public void mostrarInmuebles(){
        inmuebles.forEach(c -> System.out.println(c.toString()));
    }
}
