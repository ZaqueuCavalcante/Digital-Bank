package br.com.zup.digitalbank.dominio.transferencias;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DataDeAgendamento {

    private LocalDate data;

    public DataDeAgendamento(LocalDate data) {
        agendarPara(data);
    }

    public LocalDate data() {
        return data;
    }

    private void agendarPara(LocalDate data) {
        if (jaPassou(data)) {
            throw new IllegalArgumentException("A data de agendamento não pode ser anterior à de hoje.");
        } else if (forDiaUtil(data)) {
            this.data = data;
        } else {
            reagendarParaProximoDiaUtil(data);
        }
    }

    private boolean jaPassou(LocalDate data) {
        return data.isBefore(LocalDate.now());
    }

    private boolean forDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        return (dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY);
    }

    private void reagendarParaProximoDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY) {
            this.data = data.plusDays(2);
        } else {
            this.data = data.plusDays(1);
        }
    }

}
