package br.com.zup.digitalbank.dominio.clientes.documentos;

public class CPF extends Documento {

//    private short[] numeroBase;
//    private short regiaoFiscal;
//    private short primeiroDV;
//    private short segundoDV;

    public CPF(String numero) {
        super(numero);
    }

    @Override
    protected void validar(String numero) {
        if(numero.length() != 11) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        // Adicionar resto da validação...
        this.numero = numero;
    }

}
