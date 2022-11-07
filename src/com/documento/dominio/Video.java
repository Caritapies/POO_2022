package com.documento.dominio;

public class Video extends Archivo implements Viruseable{

    @Override
    public String nombre() {
        return null;
    }

    @Override
    public boolean tieneVirus() {
        return false;
    }
}
