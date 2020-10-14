package br.com.zup.digitalbank.dominio.transferencias.externas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamento;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;

public class PIX extends Transferencia {

    public PIX(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamento dataDeAgendamento) {
        super(valor, contaDebitada, contaCreditada, dataDeAgendamento);
    }

    @Override
    public double taxa() {
        return 0.0;
    }

    // Pode ser feita em qualquer dia da semana.
}
