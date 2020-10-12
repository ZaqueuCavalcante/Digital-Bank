package br.com.zup.digitalbank.dominio.transferencias;

import br.com.zup.digitalbank.dominio.contas.Conta;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Transferencia extends TimerTask {

    protected double valor;
    protected double taxa;

    protected Conta contaDebitada;
    protected Conta contaCreditada;

    private DataDeAgendamento dataDeAgendamento;
    private LocalDate dataDeRealizacao;

    private String descricao;

    public Transferencia(double valor, Conta contaDebitada, Conta contaCreditada, DataDeAgendamento dataDeAgendamento) {
        this.valor = valor;
        this.dataDeAgendamento = dataDeAgendamento;
        this.contaDebitada = contaDebitada;
        this.contaCreditada = contaCreditada;
        agendar();
    }

    @Override
    public void run() {
        contaDebitada.debitar(valor);
        contaCreditada.creditar(valor);
        dataDeRealizacao = LocalDate.now();
    }

    private void agendar() {
        Timer timer = new Timer();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instante = dataDeAgendamento.data().atStartOfDay(defaultZoneId).toInstant();
        timer.schedule(this, Date.from(instante));
    }

    private void reagendar(DataDeAgendamento dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public void cancelar() {
    }

}
