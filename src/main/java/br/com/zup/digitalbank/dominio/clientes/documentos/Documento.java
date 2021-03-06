package br.com.zup.digitalbank.dominio.clientes.documentos;

public abstract class Documento {

    protected String numero;

    protected Documento(String numero) {
        validar(numero);
    }

    protected abstract void validar(String numero);

    public String numero() {
        return numero;
    }

}
