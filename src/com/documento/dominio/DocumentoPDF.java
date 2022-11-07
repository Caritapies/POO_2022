package com.documento.dominio;

public class DocumentoPDF extends Documento{
    private int nroPaginas;

    public DocumentoPDF(String nombre,int nroPaginas) {
        super(nombre);
        this.nroPaginas = nroPaginas;
    }
}
