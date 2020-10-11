package br.com.zup.digitalbank.dominio.clientes.documentos;

public abstract class Documento {

    protected String numero;

    protected Documento(String numero) {
        this.numero = numero;
    }

    public String numero() {
        return numero;
    }

}
