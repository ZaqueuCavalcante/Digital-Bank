package br.com.zup.digitalbank.dominio.transferencias.internas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamentoComRestricoes;
import br.com.zup.digitalbank.dominio.transferencias.caracteristicas.Cancelavel;

public class TEV extends Transferencia implements Cancelavel {

    public TEV(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamentoComRestricoes dataDeAgendamento) {
        super(valor, contaDebitada, contaCreditada, dataDeAgendamento);
    }

    @Override
    public double taxa() {
        return 1.40;
    }

    @Override
    public void cancelar() {
        timer.cancel();
        timer.purge();
    }

}
