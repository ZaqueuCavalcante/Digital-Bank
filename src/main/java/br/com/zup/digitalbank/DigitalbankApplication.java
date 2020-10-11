package br.com.zup.digitalbank;

import br.com.zup.digitalbank.dominio.clientes.Cliente;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.DataDeNascimento;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Email;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Nome;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco.*;
import br.com.zup.digitalbank.dominio.clientes.documentos.CNPJ;
import br.com.zup.digitalbank.dominio.clientes.documentos.CPF;
import br.com.zup.digitalbank.dominio.clientes.documentos.Documento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Month;

@SpringBootApplication
public class DigitalbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalbankApplication.class, args);

		Nome nome = new Nome("Zaqueu", "do Vale Cavalcante");
		System.out.println(nome.completo());

		Email email = new Email("zaqueudovale@gmail.com");
		System.out.println(email.endereco());

		DataDeNascimento dataDeNascimento = new DataDeNascimento(02, Month.MARCH, 1998);
		System.out.println(dataDeNascimento.data());

		Endereco endereco = new Endereco(
				new CEP("55016", "080"),
				new Estado("Pernambuco", "PE"),
				new Cidade("Caruaru"),
				new Bairro("Salgado"),
				new Rua("Rua Tupy", "42"));
		System.out.println(endereco.completo());

		Documento documento = new CPF("119.245.284-44");
		System.out.println(documento.numero());

		documento = new CNPJ("75.954.151/0001-88");
		System.out.println(documento.numero());

		Cliente cliente = new Cliente(42L, nome, email, dataDeNascimento, endereco, documento);

	}

}
