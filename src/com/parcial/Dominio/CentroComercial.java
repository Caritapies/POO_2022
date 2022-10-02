package com.parcial.Dominio;

import com.agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CentroComercial {

    List<Tienda> tiendas = new ArrayList<>();
    public final byte CAPACIDAD = 100;
    private String nombre;

    public CentroComercial(String nombre) {
        this.nombre = nombre;
    }

    public boolean abrirTienda(long codigo, String nombre, List<Categoria> categorias) {
        if (this.tiendas.size() < this.CAPACIDAD && buscarTienda(codigo) == null) {
            Tienda tienda = new Tienda(codigo, nombre, categorias);

            this.tiendas.add(tienda);
            return true;
        }
        return false;
    }

    public void cerrarTienda(long codigo) {
        this.tiendas.removeIf(c -> c.getCodigo() == codigo);

    }

    public Tienda buscarTienda(String nombre) {
        return this.tiendas.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public Tienda buscarTienda(long codigo) {
        return this.tiendas.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
    }

    public List<Tienda> buscarTiendas(String categoria) {
        return this.tiendas.stream().filter(c -> c.categoriaExistente(categoria)).collect(Collectors.toList());
    }

    public List<Tienda> getTiendasConMasDeDosCategorias() {
        return this.tiendas.stream().filter(c -> c.categorias.size() > 1).collect(Collectors.toList());
    }

    public void ordenarTiendasPorNombre() {
        this.tiendas.sort(Comparator.comparing(t -> t.getNombre().toLowerCase()));
        mostrarTiendas();
    }

    public void mostrarTiendas() {
        this.tiendas.forEach(c -> System.out.println("Tienda " + c.getNombre() + " Codigo: " + c.getCodigo()));
    }
}

