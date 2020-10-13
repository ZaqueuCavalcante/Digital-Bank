package br.com.zup.digitalbank.dominio.contas.atributos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SaldoTeste {

    @Test
    public void valorInicial() {
        Saldo saldo = new Saldo();
        assertEquals(0.00, saldo.valor());
    }

    @Test
    public void primeiraCreditacao() {
        Saldo saldo = new Saldo();
        double quantia = 42.0;
        saldo.creditar(quantia);
        assertEquals(quantia, saldo.valor());
    }

    @Test
    public void multiplasOperacoes() {
        Saldo saldo = new Saldo();
        saldo.creditar(42.0);
        saldo.creditar(8.50);
        saldo.debitar(0.50);
        saldo.creditar(10.0);
        saldo.debitar(40.0);
        assertEquals(20.0, saldo.valor());
    }

    @Test
    public void zerandoSaldo() {
        Saldo saldo = new Saldo();
        saldo.creditar(42.0);
        saldo.creditar(8.50);
        saldo.debitar(0.50);
        saldo.creditar(10.0);
        saldo.debitar(60.0);
        assertEquals(0.0, saldo.valor());
    }

    @Test
    public void creditarValorNegativo() {
        Saldo saldo = new Saldo();
        double valor = -42.0;
        assertThrows(IllegalArgumentException.class, () ->
                saldo.creditar(valor));
    }

    @Test
    public void debitarValorNegativo() {
        Saldo saldo = new Saldo();
        double valor = -42.0;
        assertThrows(IllegalArgumentException.class, () ->
                saldo.debitar(valor));
    }

    @Test
    public void debitarComSaldoInsuficiente() {
        Saldo saldo = new Saldo();
        double valorCreditado = 42.0;
        double valorDebitado = 43.0;
        saldo.creditar(valorCreditado);
        assertThrows(IllegalArgumentException.class, () ->
                saldo.debitar(valorDebitado));
    }

}
