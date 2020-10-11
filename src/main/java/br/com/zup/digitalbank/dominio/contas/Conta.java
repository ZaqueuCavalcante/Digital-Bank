package br.com.zup.digitalbank.dominio.contas;

import br.com.zup.digitalbank.dominio.contas.atributos.*;

public class Conta {

    private final Agencia agencia;
    private final Tipo tipo;
    private final Numero numero;
    private final DigitoVerificador DV;

    private Favoritos favoritos;

    public Conta(Agencia agencia, Tipo tipo, Numero numero, DigitoVerificador DV) {
        this.agencia = agencia;
        this.tipo = tipo;
        this.numero = numero;
        this.DV = DV;
    }

}
