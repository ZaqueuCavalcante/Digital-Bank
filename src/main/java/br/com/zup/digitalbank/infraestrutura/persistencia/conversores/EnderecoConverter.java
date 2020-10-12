package br.com.zup.digitalbank.infraestrutura.persistencia.conversores;

import br.com.zup.digitalbank.dominio.clientes.dados.pessoais.endereco.Endereco;

import javax.persistence.AttributeConverter;

public class EnderecoConverter implements AttributeConverter<Endereco, String> {

    @Override
    public String convertToDatabaseColumn(Endereco attribute) {
        return null;
    }

    @Override
    public Endereco convertToEntityAttribute(String dbData) {
        return null;
    }

}
