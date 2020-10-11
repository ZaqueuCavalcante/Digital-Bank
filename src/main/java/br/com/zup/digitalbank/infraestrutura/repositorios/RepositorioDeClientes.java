package br.com.zup.digitalbank.infraestrutura.repositorios;

import br.com.zup.digitalbank.dominio.clientes.Cliente;

public interface RepositorioDeClientes {

    void salvar(Cliente cliente);

}
