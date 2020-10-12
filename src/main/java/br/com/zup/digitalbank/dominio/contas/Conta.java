package br.com.zup.digitalbank.dominio.contas;

import br.com.zup.digitalbank.dominio.contas.atributos.*;

public class Conta {

    private final Agencia agencia;
    private final Tipo tipo;
    private final Numero numero;
    private final DigitoVerificador DV;

    private Saldo saldo;

    private Favoritos favoritos;

    public Conta(Agencia agencia, Tipo tipo, Numero numero, DigitoVerificador DV) {
        this.agencia = agencia;
        this.tipo = tipo;
        this.numero = numero;
        this.DV = DV;
        this.saldo = new Saldo();
    }

    public double saldo() {
        return saldo.valor();
    }

    public void creditar(double valor) {
        saldo.creditar(valor);
    }

    public void debitar(double valor) {
        saldo.debitar(valor);
    }

}
