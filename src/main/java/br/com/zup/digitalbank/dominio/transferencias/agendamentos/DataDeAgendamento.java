package br.com.zup.digitalbank.dominio.transferencias.agendamentos;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class DataDeAgendamento {

    protected LocalDate data;

    protected DataDeAgendamento(LocalDate data) {
        agendarPara(data);
    }

    protected abstract void agendarPara(LocalDate data);

    public LocalDate data() {
        return data;
    }

    protected boolean jaPassou(LocalDate data) {
        return data.isBefore(LocalDate.now());
    }

    protected boolean forDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        return (dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY);
    }

    protected void reagendarParaProximoDiaUtil(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY) {
            this.data = data.plusDays(2);
        } else {
            this.data = data.plusDays(1);
        }
    }

    // Podem ser extendidos para contemplar feriados (dões) tbm (Enum)...

}
