package br.com.zup.digitalbank.dominio.transferencias.externas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamento;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamentoComRestricoes;

public class TED extends Transferencia {

    public TED(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamentoComRestricoes dataDeAgendamento) {
        super(valor, contaDebitada, contaCreditada, dataDeAgendamento);
    }

    @Override
    public double taxa() {
        return 9.50;
    }

}
