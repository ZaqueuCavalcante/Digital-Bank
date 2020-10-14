package br.com.zup.digitalbank.dominio.contas.atributos;

public class Saldo {

    private double valor = 0.00;

    public Saldo() { }

    public double valor() {
        return valor;
    }

    public void creditar(double quantia) {
        validarQuantia(quantia);
        valor += quantia;
    }

    public void debitar(double quantia) {
        validarQuantia(quantia);
        verificarSaldoSuficiente(quantia);
        valor -= quantia;
    }

    private void validarQuantia(double quantia) {
        if (quantia < 0) {
            throw new IllegalArgumentException("A quantia precisa ser um valor positivo.");
        }
    }

    private void verificarSaldoSuficiente(double quantia) {
        double saldoRestante = valor - quantia;
        if (saldoRestante < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

}
