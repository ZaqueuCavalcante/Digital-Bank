package br.com.zup.digitalbank.dominio.transferencias.internas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamentoComRestricoes;

public class TEV extends Transferencia {

    public TEV(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamentoComRestricoes dataDeAgendamento) {
        super(valor, contaDebitada, contaCreditada, dataDeAgendamento);
    }

    @Override
    public double taxa() {
        return 1.40;
    }

}
