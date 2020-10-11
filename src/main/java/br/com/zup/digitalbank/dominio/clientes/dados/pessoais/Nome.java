package br.com.zup.digitalbank.dominio.clientes.dados.pessoais;

public class Nome {

    private final String prenome;
    private final String sobrenome;

    public Nome(String prenome, String sobrenome) {
        validar(prenome);
        validar(sobrenome);
        this.prenome = prenome;
        this.sobrenome = sobrenome;
    }

    public String completo() {
        return prenome + " " + sobrenome;
    }

    private void validar(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Este campo é obrigatório.");
        }
    }

}
