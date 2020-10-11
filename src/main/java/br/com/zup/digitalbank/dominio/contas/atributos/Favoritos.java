package br.com.zup.digitalbank.dominio.contas.atributos;

import br.com.zup.digitalbank.dominio.contas.Conta;

import java.util.HashSet;
import java.util.Set;

public class Favoritos {

    private Set<Conta> favorecidos = new HashSet<>();

    public Favoritos() { }

    public void adicionar(Conta conta) {
        favorecidos.add(conta);
    }

    public void excluir(Conta conta) {
        favorecidos.remove(conta);
    }

}
