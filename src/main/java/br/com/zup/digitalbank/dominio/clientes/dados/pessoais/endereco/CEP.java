package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class CEP {

    private final String prefixo;
    private final String sufixo;

    public CEP(String prefixo, String sufixo) {
        validarPrefixo(prefixo);
        validarSufixo(sufixo);
        this.prefixo = prefixo;
        this.sufixo = sufixo;
    }

    public String formatado() {
        return "CEP " + prefixo + "-" + sufixo;
    }

    private void validarPrefixo(String prefixo) {
        if (prefixo.length() != 5) {
            throw new IllegalArgumentException("O prefixo do CEP precisa ter 5 dígitos.");
        }
    }

    private void validarSufixo(String sufixo) {
        if (sufixo.length() != 3) {
            throw new IllegalArgumentException("O sufixo do CEP precisa ter 3 dígitos.");
        }
    }

}
