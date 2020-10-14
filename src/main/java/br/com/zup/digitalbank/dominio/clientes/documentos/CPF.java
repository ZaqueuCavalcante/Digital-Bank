package br.com.zup.digitalbank.dominio.clientes.documentos;

public class CPF extends Documento {

//    private short[] numeroBase;
//    private short regiaoFiscal;
//    private short primeiroDigitoVerificador;
//    private short segundoDigitoVerificador;

    public CPF(String numero) {
        // String digitos = cpfFormatado.replaceAll("[^\\d ]", "");
        super(numero);
    }

    @Override
    protected void validar(String numero) {
        if(numero.length() != 11) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.numero = numero;
    }

}
