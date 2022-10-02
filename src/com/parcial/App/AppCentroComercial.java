package com.parcial.App;

import com.parcial.Dominio.Categoria;
import com.parcial.Dominio.CentroComercial;
import com.parcial.Dominio.Tienda;

import java.util.ArrayList;
import java.util.List;

public class AppCentroComercial{

    public static void main(String[] args) {
        Categoria juegos = new Categoria("juegos");
        Categoria tecnologia = new Categoria("tecnologia");
        Categoria ropa = new Categoria();
        Categoria superMercado = new Categoria("superMercado");
        Categoria helados = new Categoria("helados");


        CentroComercial centroComercial = new CentroComercial("San Nicolas");
        List<Categoria> categorias1 = new ArrayList<>();
        List<Categoria> categorias2 = new ArrayList<>();

        categorias1.add(juegos);
        categorias1.add(tecnologia);

        categorias2.add(ropa);


        System.out.println(centroComercial.abrirTienda(189,"HermanosTecnologia",categorias1));
        System.out.println(centroComercial.abrirTienda(189,"Hermanos",categorias2));
        System.out.println(centroComercial.abrirTienda(456,"tiendaDePedro",categorias2));
        System.out.println(centroComercial.abrirTienda(567,"exito",categorias2));
        System.out.println(centroComercial.abrirTienda(900,"Arnulfo",categorias1));

        centroComercial.ordenarTiendasPorNombre();
    }

}