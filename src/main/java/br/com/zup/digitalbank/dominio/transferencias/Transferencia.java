package br.com.zup.digitalbank.dominio.transferencias;

import br.com.zup.digitalbank.dominio.contas.Conta;

public class Transferencia {

    private double valor = 0.00;
    private static final String MOEDA = "R$";

    private String dataDeAgendamento;
    private String dataDeRealizacao;

    private String descricao;

    public Transferencia(double valor, Conta contaDebitada, Conta contaCreditada, String dataDeAgendamento) {}

    private void efetuar() {}

    private void reagendarParaProximoDiaUtil() {}

    public void cancelar() {}

}
