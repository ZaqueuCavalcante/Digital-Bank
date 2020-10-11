package br.com.zup.digitalbank.dominio.contas.atributos;

public class Numero {

    private String numero;
    private static final short QUANTIDADE_DE_DIGITOS = 8;

    public Numero(String numero) {
        validar(numero);
        this.numero = numero;
    }

    private static void validar(String numero) {
        if (numero.length() != QUANTIDADE_DE_DIGITOS) {
            throw new IllegalArgumentException("A conta deve possuir " +
                    QUANTIDADE_DE_DIGITOS + " dígitos.");
        }
    }

}
