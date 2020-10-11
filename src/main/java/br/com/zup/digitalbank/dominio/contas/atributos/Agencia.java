package br.com.zup.digitalbank.dominio.contas.atributos;

public class Agencia {

    private String numero;
    private static final short QUANTIDADE_DE_DIGITOS = 4;

    public Agencia(String numero) {
        validar(numero);
        this.numero = numero;
    }

    private static void validar(String numero) {
        if (numero.length() != QUANTIDADE_DE_DIGITOS) {
            throw new IllegalArgumentException("A agência deve possuir " +
                    QUANTIDADE_DE_DIGITOS + " dígitos.");
        }
    }

}
