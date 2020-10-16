package br.com.zup.digitalbank.dominio.transferencias.externas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamento;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamentoComRestricoes;
import br.com.zup.digitalbank.dominio.transferencias.caracteristicas.Cancelavel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DOC extends Transferencia implements Cancelavel {

    public DOC(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamentoComRestricoes dataDeAgendamento) {
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

    // Um DOC agendado poderá ser cancelado até às 18hs do dia útil de envio.
    // Caso esteja agendado para segunda-feira, mas eu tente cancelar no
    // sábado ou domingo, o que acontece?
    private boolean forPossivelCancelar() {
        return true;
    }

}
