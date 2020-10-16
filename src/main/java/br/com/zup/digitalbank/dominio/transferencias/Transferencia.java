package br.com.zup.digitalbank.dominio.transferencias;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.transferencias.agendamentos.DataDeAgendamento;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Transferencia extends TimerTask {

    protected int id;
    protected Timer timer = new Timer();

    protected double valor;

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

    public double valor() {
        return valor;
    }

    public abstract double taxa();

    public void adicionarDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void run() {
        contaDebitada.debitar(valor);
        contaCreditada.creditar(valor);
        dataDeRealizacao = LocalDate.now();
    }

    private void agendar() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instante = dataDeAgendamento.data().atStartOfDay(defaultZoneId).toInstant();
        timer.schedule(this, Date.from(instante));
    }

    public void reagendar(DataDeAgendamento dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

}
