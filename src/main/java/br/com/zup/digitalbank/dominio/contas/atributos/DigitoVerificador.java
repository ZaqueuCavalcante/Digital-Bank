package br.com.zup.digitalbank.dominio.contas.atributos;

public class DigitoVerificador {

    private char digito;

    public DigitoVerificador(char digito) {
        validar(digito);
        this.digito = digito;
    }

    private static void validar(char digito) {
        if (!Character.isDigit(digito)) {
            throw new IllegalArgumentException("O dígito verificador precisa ser um número de 0 a 9.");
        }
    }

}
