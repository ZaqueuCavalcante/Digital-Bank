package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class Bairro {

    private final String nome;

    public Bairro(String nome) {
        validar(nome);
        this.nome = nome;
    }

    public String nome() {
        return nome;
    }

    private void validar(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do bairro é obrigatório.");
        }
    }

}
