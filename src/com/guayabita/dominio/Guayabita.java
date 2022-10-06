package com.guayabita.dominio;
import java.lang.Math;

public class Guayabita {
    private int pote;
    private int caceMinimo;
    public static final int JUGAR = 0;
    public static final int INSTRUCCIONES = 1;

    public static String getInstrucciones() {
        return """
                1. Posee dos jugadores, cada uno empieza con una determinada suma de dinero.
                 
                2. Se establece una apuesta minima , denominada case.
                
                3. Cada jugador debe colocar el valor del case en la mesa.
                  
                4. Se efectuaran turnos, en los que el jugador lanza el dado, segun el resultado
                se pueden dar las siguientes posibilidades. Al sacar 1 o 6, pierde, y debe colocar
                el valor del case en la mesa, cambio de turno. Al sacar 2,3,4,5 posee un segundo
                turno. En el segundo lanzamiento debe obtener un numero mayor al primer
                lanzamiento, si esto sucede, el jugador ganara el valor apostado, de lo\s
                contrario perdera lo apostado, y se cambiara el turno.
                
                5. El juego termina cuando un jugador o la mesa no posee mas dinero.
                
                """;
    }

    public Guayabita(int caceMinimo) {
        this.pote = 0;
        this.caceMinimo = caceMinimo;
    }

    public boolean iniciarJuego(Jugador jugador1, Jugador jugador2){
        if(jugador1.getDinerro() >= caceMinimo && jugador2.getDinerro() >= caceMinimo){
            jugador1.setDinerro(jugador1.getDinerro() - caceMinimo);
            jugador2.setDinerro(jugador2.getDinerro() - caceMinimo);
            this.pote += 2*caceMinimo;
            return true;
        }
        return false;
    }
    public boolean apostar(int cantidadApostada,Jugador jugador){

        if (cantidadApostada<=pote && jugador.getDinerro() >= cantidadApostada){
            jugador.setDinerro(jugador.getDinerro() - cantidadApostada);
            this.pote += cantidadApostada;
            return true;
        }
        return false;
    }
    public void ganar(Jugador jugador,int cantidadApostada){
        jugador.setDinerro(jugador.getDinerro() + 2*cantidadApostada);
        this.pote -= 2*cantidadApostada;
    }
    public int getPote() {
        return pote;
    }
}
