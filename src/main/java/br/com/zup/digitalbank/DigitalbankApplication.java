package br.com.zup.digitalbank;

import br.com.zup.digitalbank.dominio.clientes.Cliente;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.DataDeNascimento;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Email;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Nome;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.Senha;
import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco.*;
import br.com.zup.digitalbank.dominio.clientes.documentos.CNPJ;
import br.com.zup.digitalbank.dominio.clientes.documentos.CPF;
import br.com.zup.digitalbank.dominio.clientes.documentos.Documento;
import br.com.zup.digitalbank.dominio.contas.Conta;
import br.com.zup.digitalbank.dominio.contas.atributos.Agencia;
import br.com.zup.digitalbank.dominio.contas.atributos.DigitoVerificador;
import br.com.zup.digitalbank.dominio.contas.atributos.Numero;
import br.com.zup.digitalbank.dominio.contas.atributos.Tipo;
import br.com.zup.digitalbank.dominio.transferencias.DataDeAgendamento;
import br.com.zup.digitalbank.dominio.transferencias.Transferencia;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class DigitalbankApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
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

		Senha senha = new Senha("1Z34z678");
		System.out.println(senha.encodada());

		Conta contaDebitada = new Conta(
				new Agencia("0051"),
				Tipo.POUPANCA_PF,
				new Numero("00094170"),
				new DigitoVerificador('7'));
		contaDebitada.creditar(200);

		Conta contaCreditada = new Conta(
				new Agencia("0042"),
				Tipo.POUPANCA_PF,
				new Numero("00094850"),
				new DigitoVerificador('9'));

		System.out.println(contaDebitada.saldo());
		System.out.println(contaCreditada.saldo());

		Transferencia transferencia = new Transferencia(
				100,
				contaDebitada,
				contaCreditada,
				new DataDeAgendamento(LocalDate.of(2020, Month.OCTOBER, 13)));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(contaDebitada.saldo());
		System.out.println(contaCreditada.saldo());
	}

}
