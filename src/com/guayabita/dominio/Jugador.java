package com.guayabita.dominio;

public class Jugador {
    private final String nombre;
    private int dinerro;

    public Jugador(String nombre, int dinerro) {
        this.nombre = nombre;
        this.dinerro = dinerro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinerro() {
        return dinerro;
    }

    public void setDinerro(int dinerro) {
        this.dinerro = dinerro;
    }
    public int tirarDado(){
        return (byte) (Math.random() * 6)+1;
    }

}
