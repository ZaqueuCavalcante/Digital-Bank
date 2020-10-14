package br.com.zup.digitalbank.dominio.transferencias.agendamentos;

import java.time.LocalDate;

public class DataDeAgendamentoComRestricoes extends DataDeAgendamento {

    public DataDeAgendamentoComRestricoes(LocalDate data) {
        super(data);
    }

    @Override
    protected void agendarPara(LocalDate data) {
        if (jaPassou(data)) {
            throw new IllegalArgumentException("A data de agendamento não pode ser anterior à de hoje.");
        } else if (forDiaUtil(data)) {
            this.data = data;
        } else {
            reagendarParaProximoDiaUtil(data);
        }
    }

}
