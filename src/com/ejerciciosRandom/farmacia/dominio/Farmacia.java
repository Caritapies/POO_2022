package com.ejerciciosRandom.farmacia.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farmacia {
    List<Farmaco> farmacos = new ArrayList<>();
    private int dineroRecibido;

    public boolean agregarFarmaco(String nombre, int cantidadGramos, int cantidadTabletas, int precio){
        farmacos.add(new Farmaco(nombre,cantidadGramos,cantidadTabletas,precio));
        return true;
    }

    public void sacarFarmaco(String nombre, int gramaje){
        farmacos.removeIf(farmaco -> farmaco.getNombre().equalsIgnoreCase(nombre) && farmaco.getCantidadGramos() == gramaje);
    }
    public boolean venderFarmacos(String nombre, int gramaje, int cantidad){
        for(Farmaco farmaco: farmacos){
            if (farmaco.getNombre().equalsIgnoreCase(nombre) && farmaco.getCantidadGramos() == gramaje){
                farmaco.setCantidad(farmaco.getCantidad() - cantidad);

                return true;
            }
        }
        return false;
    }

    public List<Farmaco> buscarFarmacoPorNombre(String nombre){
        return this.farmacos.stream().filter(c -> c.getNombre().toLowerCase().startsWith(nombre.toLowerCase())).collect(Collectors.toList());
    }
    public boolean cambiarPrecioFarmaco(Farmaco farmaco, int precioNuevo){
        return true;
    }
    public void mostrarCatalogo(){
        farmacos.forEach((c-> System.out.println(c.getNombre() + " "+c.getCantidadGramos()+" gramos "+c.getPrecio()+"$")));
    }

}
