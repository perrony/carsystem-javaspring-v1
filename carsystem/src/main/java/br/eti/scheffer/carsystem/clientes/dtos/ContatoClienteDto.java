package br.eti.scheffer.carsystem.clientes.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ContatoClienteDto {
	
	private Long id;
	
	@NotNull(message = "Descrição não pode ser nula")
	@NotEmpty(message = "Descrição não pode ser em branco")
	@Length(min = 3, max = 45, message = "Descrição do contato deve conter entre 3 e 45 caracteres.")
	private String descricao;
	
	@NotNull(message = "Contato não pode ser nulo")
	@NotEmpty(message = "Contato não pode ser em branco")
	private String contato;
	
	@NotNull(message = "Tipo não pode ser nulo")
	@NotEmpty(message = "Tipo não pode ser em branco")
	private String tipoContato;
	
	@NotNull(message = "Cliente não pode ser nulo")
	@Min(value = 1, message = "Cliente não pode ser menor que 1")
	private Long cliente;
	
	@NotNull(message = "Usuário não pode ser nulo")
	private Long users;
	
	
	public ContatoClienteDto() {}
	
}

	