package br.com.zup.digitalbank.dominio.clientes.documentos;

public class CNPJ extends Documento {

    public CNPJ(String numero) {
        super(numero);
    }

    @Override
    protected void validar(String numero) {
        if(numero.length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }
        this.numero = numero;
    }

}
