package br.com.zup.digitalbank.dominio.clientes.dados.pessoais;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DataDeNascimento {

    private final String data;
    private static final short IDADE_MINIMA_PARA_ABRIR_CONTA = 18;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    public DataDeNascimento(int dia, Month mes, int ano) {
        validar(dia, mes, ano);
        data = LocalDate.of(ano, mes, dia).format(formatter);
    }

    public String data() {
        return data;
    }

    private void validar(int dia, Month mes, int ano) {
        int idade = Period.between(LocalDate.of(ano, mes, dia), LocalDate.now()).getYears();
        if (idade < IDADE_MINIMA_PARA_ABRIR_CONTA) {
            throw new IllegalArgumentException("A idade mínima para poder abrir uma conta é de " +
                    IDADE_MINIMA_PARA_ABRIR_CONTA + " anos.");
        }
    }

}
