package com.guayabita.App;

import com.guayabita.dominio.Guayabita;
import com.guayabita.dominio.Jugador;

import javax.swing.*;

public class AppGuayabita {
    private static final ImageIcon ICONO = new ImageIcon(AppGuayabita.class.getResource("guayaba.png"));
    private static final ImageIcon PERSONA = new ImageIcon(AppGuayabita.class.getResource("person.png"));
    private static final ImageIcon DADO_1 = new ImageIcon(AppGuayabita.class.getResource("dado1.png"));
    private static final ImageIcon DADO_2 = new ImageIcon(AppGuayabita.class.getResource("dado2.png"));
    private static final ImageIcon DADO_3 = new ImageIcon(AppGuayabita.class.getResource("dado3.png"));
    private static final ImageIcon DADO_4 = new ImageIcon(AppGuayabita.class.getResource("dado4.png"));
    private static final ImageIcon DADO_5 = new ImageIcon(AppGuayabita.class.getResource("dado5.png"));
    private static final ImageIcon DADO_6 = new ImageIcon(AppGuayabita.class.getResource("dado6.png"));

    public static void main(String[] args) {
        int eleccion,pote,dinero;
        String nombre;
        boolean jugando = true;


        eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al Juego de la Guayabita :D", "La Guayabita", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, ICONO, new Object[]{"Jugar", "Instrucciones"}, "Jugar");
        while(eleccion == Guayabita.INSTRUCCIONES){
            mostrarMensaje(Guayabita.getInstrucciones(),null);
            eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al Juego de la Guayabita :D", "La Guayabita", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, ICONO, new Object[]{"Jugar", "Instrucciones"}, "Jugar");
        }
        if (eleccion == Guayabita.JUGAR) {
            pote = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el cace para cada jugador", "Pote", JOptionPane.INFORMATION_MESSAGE));

            nombre = (String) JOptionPane.showInputDialog(null, "Ingresa el nombre del primer jugador", "Jugador 1", JOptionPane.PLAIN_MESSAGE, PERSONA, null, "Nombre");
            dinero = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingresa el dinero total del primer jugador", "Jugador 1", JOptionPane.PLAIN_MESSAGE, PERSONA, null, "Dinero"));
            Jugador jugador1 = new Jugador(nombre, dinero);

            nombre = (String) JOptionPane.showInputDialog(null, "Ingresa el nombre del segundo jugador", "Jugador 2", JOptionPane.PLAIN_MESSAGE, PERSONA, null, "Nombre");
            dinero = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingresa el dinero total del segundo jugador", "Jugador 2", JOptionPane.PLAIN_MESSAGE, PERSONA, null, "Dinero"));
            Jugador jugador2 = new Jugador(nombre, dinero);

            Guayabita juegoGuayabita = new Guayabita(pote);

            if (juegoGuayabita.iniciarJuego(jugador1, jugador2)) {
                while (jugando) {
                    mostrarMensaje("El valor del pote actualmente es : " + juegoGuayabita.getPote(), ICONO);
                    mostrarMensaje("Turno de " + jugador1.getNombre(), ICONO);

                    if (!jugarYGanar(jugador1, juegoGuayabita)) {
                        mostrarMensaje("Turno de " + jugador2.getNombre(), ICONO);
                        if (jugarYGanar(jugador2, juegoGuayabita)) {
                            jugando = juegoGuayabita.iniciarJuego(jugador1, jugador2);
                        }
                    } else {
                        jugando = juegoGuayabita.iniciarJuego(jugador1, jugador2);
                    }
                    mostrarMensaje("El dinero del jugador " + jugador1.getNombre() + " es " + jugador1.getDinerro() + "\nEl dinero del jugador " + jugador2.getNombre() + " es " + jugador2.getDinerro(), ICONO);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El juego acabó");
                mostrarMensaje("El dinero restante de " + jugador1.getNombre() + " es " + jugador1.getDinerro(), ICONO);
                mostrarMensaje("El dinero restante de " + jugador2.getNombre() + " es " + jugador2.getDinerro(), ICONO);
            }
        }


    }
    public static void mostrarMensaje(String mensaje, ImageIcon icon){
        JOptionPane.showMessageDialog(null,  mensaje, "Guayabita", JOptionPane.PLAIN_MESSAGE, icon);
    }
    public static int mostrarDado(ImageIcon icon,Jugador jugador, Guayabita juego){
        return JOptionPane.showConfirmDialog(null, jugador.getNombre()+", ¿quieres apostar? (El pote actual es de "+juego.getPote()+"$)", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
    }
    public static boolean jugarYGanar(Jugador jugador, Guayabita juegoGuayabita) {

        int aceptarTirar,tiro1,tiro2,salida,apuesta;

        aceptarTirar = JOptionPane.showConfirmDialog(null, "¿Quieres Tirar el dado?", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, ICONO);
        if (aceptarTirar == JOptionPane.YES_OPTION) {

            tiro1 = jugador.tirarDado();
            if (tiro1 == 1) {
                mostrarMensaje("Cediendo turno", DADO_1);
            } else if (tiro1 == 6) {
                mostrarMensaje("Cediendo turno", DADO_6);
            } else {
                switch (tiro1) {
                    case 2 -> salida = mostrarDado(DADO_2, jugador, juegoGuayabita);
                    case 3 -> salida = mostrarDado(DADO_3, jugador, juegoGuayabita);
                    case 4 -> salida = mostrarDado(DADO_4, jugador, juegoGuayabita);
                    case 5 -> salida = mostrarDado(DADO_5, jugador, juegoGuayabita);
                    default -> salida = -1;
                }

                if (salida == JOptionPane.YES_OPTION) {

                    apuesta = Integer.parseInt(JOptionPane.showInputDialog("Cuanto quiere apostar?"));
                    if(juegoGuayabita.apostar(apuesta,jugador)){
                        tiro2 = jugador.tirarDado();
                        switch (tiro2) {
                            case 1 -> mostrarMensaje("", DADO_1);
                            case 2 -> mostrarMensaje("", DADO_2);
                            case 3 -> mostrarMensaje("", DADO_3);
                            case 4 -> mostrarMensaje("", DADO_4);
                            case 5 -> mostrarMensaje("", DADO_5);
                            case 6 -> mostrarMensaje("", DADO_6);

                        }
                        if (tiro2 > tiro1) {
                            juegoGuayabita.ganar(jugador,apuesta);
                            mostrarMensaje("Has ganado la apuesta!", PERSONA);
                            return true;

                        } else {
                            mostrarMensaje(jugador.getNombre() + " has perdido la apuesta", ICONO);
                        }
                    }else{
                        mostrarMensaje("Lo siento, no tienes para apostar esa cantidad",ICONO);
                    }

                }
            }
        }
        return false;
    }
}