package br.com.zup.digitalbank.dominio.contas.atributos;

public class Tipo {

    private String numero;
    private static final short QUANTIDADE_DE_DIGITOS = 3;

    public Tipo(String numero) {
        validar(numero);
        this.numero = numero;
    }

    private static void validar(String numero) {
        if (numero.length() != QUANTIDADE_DE_DIGITOS) {
            throw new IllegalArgumentException("O tipo da conta deve possuir " +
                    QUANTIDADE_DE_DIGITOS + " dígitos.");
        }
    }

}
