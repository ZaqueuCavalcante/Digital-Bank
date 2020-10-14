package br.com.zup.digitalbank.dominio.transferencias.agendamentos;

import java.time.LocalDate;

public class DataDeAgendamentoAtemporal extends DataDeAgendamento {

    protected DataDeAgendamentoAtemporal(LocalDate data) {
        super(data);
    }

    @Override
    protected void agendarPara(LocalDate data) {
        this.data = data;
    }

}
