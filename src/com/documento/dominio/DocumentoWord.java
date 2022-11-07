package com.documento.dominio;

public class DocumentoWord extends Documento implements Viruseable{

    private boolean protegido;

    public DocumentoWord(String nombre,boolean protegido) {
        super(nombre);
        this.protegido = protegido;
    }

    @Override
    public String nombre() {
        return this.getNombre();
    }

    @Override
    public boolean tieneVirus() {
        return false;
    }
}
