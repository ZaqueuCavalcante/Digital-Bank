package br.com.zup.digitalbank.dominio.contas.especificas;

import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.contas.atributos.Agencia;
import br.com.zup.digitalbank.dominio.contas.atributos.DigitoVerificador;
import br.com.zup.digitalbank.dominio.contas.atributos.Numero;
import br.com.zup.digitalbank.dominio.contas.atributos.Tipo;
import br.com.zup.digitalbank.dominio.contas.caracteristicas.Tributavel;

public class Investimento extends Conta implements Tributavel {

    public Investimento(Agencia agencia, Tipo tipo, Numero numero, DigitoVerificador DV) {
        super(agencia, tipo, numero, DV);
    }

}
