package com.guayabita.App;

import com.guayabita.dominio.Guayabita;
import com.guayabita.dominio.Jugador;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AppGuayabita {
    private static final ImageIcon ICONO = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("guayaba.png")));
    private static final ImageIcon PERSONA = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("person.png")));
    private static final ImageIcon DADO_1 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado1.png")));
    private static final ImageIcon DADO_2 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado2.png")));
    private static final ImageIcon DADO_3 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado3.png")));
    private static final ImageIcon DADO_4 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado4.png")));
    private static final ImageIcon DADO_5 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado5.png")));
    private static final ImageIcon DADO_6 = new ImageIcon(Objects.requireNonNull(AppGuayabita.class.getResource("dado6.png")));
    static List<ImageIcon> dados = Arrays.asList(DADO_1, DADO_2, DADO_3, DADO_4, DADO_5, DADO_6);
    private static boolean rendirse = false;

    public static void main(String[] args) {
        int eleccion = 0,pote,dinero;
        String nombre;

        while(eleccion != JOptionPane.CLOSED_OPTION){

            eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al Juego de la Guayabita :D\n ¿Qué quieres hacer?", "La Guayabita", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, ICONO, new Object[]{"Jugar", "Instrucciones"}, "Jugar");

            while(eleccion == Guayabita.INSTRUCCIONES){
                mostrarMensaje(Guayabita.getInstrucciones(),null);
                eleccion = JOptionPane.showOptionDialog(null, "Bienvenido al Juego de la Guayabita :D\n ¿Qué quieres hacer?", "La Guayabita", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, ICONO, new Object[]{"Jugar", "Instrucciones"}, "Jugar");
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

                while (juegoGuayabita.iniciarJuego(jugador1,jugador2)) {

                        mostrarMensaje("Poniendo cace...",ICONO);
                        mostrarMensaje("El valor del pote actualmente es : " + juegoGuayabita.getPote()+"\n"+jugador1.getNombre()+": "+jugador1.getDinerro()+"\n"+jugador2.getNombre()+": "+jugador2.getDinerro(), ICONO);
                        mostrarMensaje("Turno de " + jugador1.getNombre(), ICONO);

                        if (!jugarYGanar(jugador1, juegoGuayabita)) {

                            if(rendirse)
                                break;
                            mostrarMensaje("Turno de " + jugador2.getNombre(), ICONO);
                            jugarYGanar(jugador2, juegoGuayabita);
                            if(rendirse)
                                break;

                        }
                }
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
        return JOptionPane.showConfirmDialog(null, jugador.getNombre()+",este es tu dado, ¿quieres apostar? (El pote actual es de "+juego.getPote()+"$)", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
    }
    public static boolean jugarYGanar(Jugador jugador, Guayabita juegoGuayabita) {

        int aceptarTirar,tiro1,tiro2,salida,apuesta;
        boolean apuestaValida = false;

        aceptarTirar = JOptionPane.showConfirmDialog(null, jugador.getNombre()+", ¿Quieres Tirar el dado?\n El pote actual es de "+juegoGuayabita.getPote(), "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, ICONO);
        if (aceptarTirar == JOptionPane.YES_OPTION) {

            tiro1 = jugador.tirarDado();
            if (tiro1 == 1) {
                mostrarMensaje("Cediendo turno", DADO_1);
            } else if (tiro1 == 6) {
                mostrarMensaje("Cediendo turno", DADO_6);
            } else {
                salida = mostrarDado(AppGuayabita.dados.get(tiro1-1),jugador,juegoGuayabita);

                if (salida == JOptionPane.YES_OPTION) {
                    do{
                        apuesta = Integer.parseInt(JOptionPane.showInputDialog(jugador.getNombre()+", ¿Cuánto quieres apostar?\n tu dinero es: "+jugador.getDinerro()+"\nY el dinero del pote es: "+juegoGuayabita.getPote()));

                        if(juegoGuayabita.apostar(apuesta,jugador)){
                            apuestaValida = true;
                            tiro2 = jugador.tirarDado();
                            mostrarMensaje(jugador.getNombre()+" este es tu tiro",dados.get(tiro2-1));
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
                    }while (!apuestaValida);

                }
            }
        }else{
            rendirse = true;
        }
        return false;
    }
}

