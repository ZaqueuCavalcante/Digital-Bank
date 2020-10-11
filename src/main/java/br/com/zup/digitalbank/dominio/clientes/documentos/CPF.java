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

}
