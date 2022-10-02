package com.parcial.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private long codigo;
    private String nombre;
    List<Categoria> categorias;

    public Tienda(long codigo, String nombre, List<Categoria> categorias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean categoriaExistente(String categoria){
        for (Categoria i: categorias) {
            if (i.getNombre().equalsIgnoreCase(categoria)) {
                return true;
            }
        }
        return false;
    }
    public void mostrarCategorias(){
        this.categorias.forEach(c-> System.out.print(c.getNombre()+" "));
    }
}
