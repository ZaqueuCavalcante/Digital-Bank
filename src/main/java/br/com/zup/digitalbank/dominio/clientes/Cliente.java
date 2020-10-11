package br.com.zup.digitalbank.dominio.clientes;

import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.DataDeNascimento;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Email;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Nome;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco.Endereco;
import br.com.zup.digitalbank.dominio.clientes.documentos.Documento;
import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;

public class Cliente {

    private final Long id;

    private final Nome nome;
    private final Email email;
    private final DataDeNascimento dataDeNascimento;
    private final Endereco endereco;

    private final Documento documento;

    private Conta conta;

    public Cliente(Long id, Nome nome, Email email, DataDeNascimento dataDeNascimento, Endereco endereco, Documento documento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.documento = documento;
    }

    public void realizar(Transferencia transferencia, Conta conta) { }

    public void receber(Transferencia transferencia, Conta conta) { }

}
