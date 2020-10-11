package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class Rua {

    private final String nome;
    private final String numero;

    public Rua(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String completa() {
        return nome + ", n° " + numero;
    }

    private void validar(String nome, String numero) {
        if (nome.isEmpty() || numero.isEmpty()) {
            throw new IllegalArgumentException("O nome e o número da rua são obrigatórios.");
        }
    }

}
