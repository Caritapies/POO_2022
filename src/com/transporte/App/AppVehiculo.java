package com.transporte.App;

import com.transporte.dominio.*;

import java.util.ArrayList;
import java.util.List;

public class AppVehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        Carro carro = new Carro();

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new BiciMTB());
        vehiculos.add(new Bicicleta());
        vehiculos.add(new Vehiculo());
        vehiculos.add(new Taxi());

        vehiculos.forEach(System.out::println);
    }
}
