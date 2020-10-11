package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class Cidade {

    private final String nome;

    public Cidade(String nome) {
        validar(nome);
        this.nome = nome;
    }

    public String nome() {
        return nome;
    }

    private void validar(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da cidade é obrigatório.");
        }
    }

}
