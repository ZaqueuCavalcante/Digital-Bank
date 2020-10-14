package br.com.zup.digitalbank.dominio.contas;

import br.com.zup.digitalbank.dominio.contas.atributos.*;

import java.util.Objects;
import java.util.Set;

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

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public String agencia() {
        return agencia.numero();
    }

    public String tipo() {
        return tipo.codigo();
    }

    public String numero() {
        return numero.ver();
    }

    public char DV() {
        return DV.ver();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public double saldo() {
        return saldo.valor();
    }

    public void creditar(double valor) {
        saldo.creditar(valor);
    }

    public void debitar(double valor) {
        saldo.debitar(valor);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public void adicionarFavorecido(Conta conta) {
        favoritos.adicionar(conta);
    }

    public void removerFavorecido(Conta conta) {
        favoritos.remover(conta);
    }

    public void editarFavorecido(Conta aSerEditada, Conta editada) {
        favoritos.editar(aSerEditada, editada);
    }

    public Set<Conta> verTodosOsFavorecidos() {
        return favoritos.verTodos();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia.equals(conta.agencia) &&
                tipo == conta.tipo &&
                numero.equals(conta.numero) &&
                DV.equals(conta.DV) &&
                saldo.equals(conta.saldo) &&
                favoritos.equals(conta.favoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, tipo, numero, DV, saldo, favoritos);
    }

}
