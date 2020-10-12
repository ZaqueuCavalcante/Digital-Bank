package br.com.zup.digitalbank.dominio.clientes.dados.pessoais;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private final String endereco;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public Email(String endereco) {
        validar(endereco);
        this.endereco = endereco;
    }

    public String endereco() {
        return endereco;
    }

    private void validar(String endereco) {
        if (endereco.isEmpty()) {
            throw new IllegalArgumentException("O endereço de e-mail é obrigatório.");
        }
        Matcher matcher = pattern.matcher(endereco);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Endereço de e-mail inválido.");
        }
    }

}
