package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class Estado {

    private final String nome;
    private final String UF;

    public Estado(String nome, String UF) {
        this.nome = nome;
        this.UF = UF;
    }

    public String nome() {
        return nome;
    }

    public String UF() {
        return UF;
    }

    private void validarNome(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do estado é obrigatório.");
        }
    }

    private void validarUF(String UF) {
        if (UF.isEmpty()) {
            throw new IllegalArgumentException("A UF do estado é obrigatória.");
        }
        if (UF.length() != 2) {
            throw new IllegalArgumentException("A UF do estado deve conter duas letras.");
        }
    }

}
