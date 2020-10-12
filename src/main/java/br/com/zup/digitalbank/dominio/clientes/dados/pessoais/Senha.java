package br.com.zup.digitalbank.dominio.clientes.dados.pessoais;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Senha {

    private final String senha;
    private static final short QUANTIDADE_DE_DIGITOS = 8;

    public Senha(String senha) {
        validar(senha);
        this.senha = senha;
    }

    private void validar(String senha) {
        if (senha.length() != QUANTIDADE_DE_DIGITOS) {
            throw new IllegalArgumentException("A senha deve conter " + QUANTIDADE_DE_DIGITOS + " dígitos.");
        }
        if (!possuiDigitoEntre(senha, 'a', 'z')) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!possuiDigitoEntre(senha, 'A', 'Z')) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
    }

    private boolean possuiDigitoEntre(String senha, char limiteInferior, char limiteSuperior) {
        for (char digito : senha.toCharArray()) {
            if (digito >= limiteInferior && digito <= limiteSuperior) {
                return true;
            }
        }
        return false;
    }

    public String encodada() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        return algoritmo.digest(senha.getBytes("UTF-8")).toString();
    }

}
