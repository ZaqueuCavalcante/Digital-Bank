package br.com.zup.digitalbank.dominio.transferencias.agendamentos;

import java.time.LocalDate;

public class DataDeAgendamentoAtemporal extends DataDeAgendamento {

    // Em caso de viagem no tempo, permite agendar uma transferência
    // para ser feita no passado.
    // Viola o YAGNI Principle? Não, pois é uma funcionalidade feita
    // para ser possivelmente utilizada no passado.

    protected DataDeAgendamentoAtemporal(LocalDate data) {
        super(data);
    }

    @Override
    protected void agendarPara(LocalDate data) {
        this.data = data;
    }

}
