package br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco;

public class Endereco {

    private final CEP CEP;
    private final Estado estado;
    private final Cidade cidade;
    private final Bairro bairro;
    private final Rua rua;

    public Endereco(CEP CEP, Estado estado, Cidade cidade, Bairro bairro, Rua rua) {
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String completo() {
        return rua.completa() + ", " + bairro.nome() + " - " +
                cidade.nome() + " " + estado.UF() + " - " + CEP.formatado();
    }

}
