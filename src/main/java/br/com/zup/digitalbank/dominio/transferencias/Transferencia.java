package br.com.zup.digitalbank.dominio.transferencias;

import br.com.zup.digitalbank.dominio.contas.Conta;
import org.apache.tomcat.jni.Local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class Transferencia {

    private double valor = 0.00;
    private static final String MOEDA = "R$";

    protected double taxa;

    private LocalDate dataDeAgendamento;
    private LocalDate dataDeRealizacao;

    private String descricao;

    public Transferencia(double valor, Conta contaDebitada, Conta contaCreditada, LocalDate dataDeAgendamento) {}

    private void efetuar() {}

    private void agendarPara(LocalDate data) {
        if (forDiaUtil(data)) {
            this.dataDeAgendamento = data;
        } else {
            reagendarParaProximoDiaUtil(data);
        }
    }

    private boolean forDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        return (dia != DayOfWeek.SATURDAY || dia != DayOfWeek.SUNDAY);
    }

    private void reagendarParaProximoDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY) {
            this.dataDeAgendamento = data.plusDays(2);
        } else {
            this.dataDeAgendamento = data.plusDays(1);
        }
    }

    public void cancelar() {}

}
