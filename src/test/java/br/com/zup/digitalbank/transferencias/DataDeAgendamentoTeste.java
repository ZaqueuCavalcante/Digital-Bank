package br.com.zup.digitalbank.transferencias;

import br.com.zup.digitalbank.dominio.transferencias.DataDeAgendamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataDeAgendamentoTeste {

    @Test
    public void agendarParaDataPassada() {
        LocalDate dataPassada = LocalDate.of(2015, Month.OCTOBER, 21);
        assertThrows(IllegalArgumentException.class, () ->
                new DataDeAgendamento(dataPassada));
    }

    @Test
    public void agendarParaDiaUtil() {
        LocalDate umaSextaQualquer = LocalDate.of(2077, Month.AUGUST, 13);
        DataDeAgendamento dataDeAgendamento = new DataDeAgendamento(umaSextaQualquer);
        assertEquals(umaSextaQualquer, dataDeAgendamento.data());
    }

    @Test
    public void agendarParaSabado() {
        LocalDate umSabadoQualquer = LocalDate.of(2077, Month.AUGUST, 14);
        DataDeAgendamento dataDeAgendamento = new DataDeAgendamento(umSabadoQualquer);
        assertEquals(umSabadoQualquer.plusDays(2), dataDeAgendamento.data());
    }

    @Test
    public void agendarParaDomingo() {
        LocalDate umDomingoQualquer = LocalDate.of(2077, Month.AUGUST, 15);
        DataDeAgendamento dataDeAgendamento = new DataDeAgendamento(umDomingoQualquer);
        assertEquals(umDomingoQualquer.plusDays(1), dataDeAgendamento.data());
    }

}
