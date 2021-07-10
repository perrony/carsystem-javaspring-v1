package br.eti.scheffer.carsystem.clientes.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class EnderecoClientesDto {


	private Long id;
	
	@NotNull(message = "Descrição do endereço não pode ser nulo")
	@NotEmpty(message = "Descrição do endereço não pode ser vazio")
	private String descricao;
	
	private String complemento;
	
	private String numero;

	private String unidade;

	private String ibge;

	private String gia;

	private String cep;

	@NotNull(message = "Logradouro não pode ser nulo")
	@NotEmpty(message = "Logradouro não pode ser vazio")
	private String logradouro;

	@NotNull(message = "Bairro não pode ser nulo")
	@NotEmpty(message = "Bairro não pode ser vazio")
	private String bairro;

	@NotNull(message = "Cidade não pode ser nulo")
	@NotEmpty(message = "Cidade não pode ser vazio")
	private String localidade;

	@NotNull(message = "Uf não pode ser nulo")
	@NotEmpty(message = "Uf não pode ser vazio")
	private String uf;

	private String siafi;

	@NotNull(message = "Identificação do cliente não pode ser nulo")
	private Long clientes;

	@NotNull(message = "Identificação do usuário não pode ser nulo")
	private Long users;
	
	public EnderecoClientesDto() {}
	
}

