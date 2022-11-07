package com.documento.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Antivirus {
    private List<Viruseable> elementosAExaminar;
    public Antivirus(){
        this.elementosAExaminar = new ArrayList<>();
    }
    public void agregar(Viruseable elem){
        this.elementosAExaminar.add(elem);
    }
    public void escanear(){
        AtomicInteger virusEncontrados = new AtomicInteger();
        this.elementosAExaminar.forEach(elem -> {
            System.out.println("Iniciando busqueda de virus");
            if(elem.tieneVirus()){
                System.out.println(elem.nombre() + "tiene virus ");
                virusEncontrados.getAndIncrement();
            }
            System.out.println("Terminó la busqueda de virus");
        });
    }
}
