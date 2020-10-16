package br.com.zup.digitalbank.dominio.transferencias.externas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamento;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamentoComRestricoes;
import br.com.zup.digitalbank.dominio.transferencias.caracteristicas.Cancelavel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TED extends Transferencia implements Cancelavel {

    public TED(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamentoComRestricoes dataDeAgendamento) {
        super(valor, contaDebitada, contaCreditada, dataDeAgendamento);
    }

    @Override
    public double taxa() {
        return 9.50;
    }

    @Override
    public void cancelar() {
        if (forPossivelCancelar()) {
            timer.cancel();
            timer.purge();
        } else {
            // Melhorar a exception...
            throw new RuntimeException("Não é possível cancelar a transferência.");
        }
    }

    // Um TED agendado pode ser cancelado até 1 dia útil antes da data de envio.
    // Caso esteja agendado para segunda-feira, mas eu tente cancelar no
    // sábado ou domingo, o que acontece?
    private boolean forPossivelCancelar() {
        long diasFaltantes = ChronoUnit.DAYS.between(LocalDate.now(), dataDeAgendamento.data());
        return diasFaltantes >= 1;
    }

}
