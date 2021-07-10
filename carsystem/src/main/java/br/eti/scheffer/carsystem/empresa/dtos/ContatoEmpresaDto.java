package br.eti.scheffer.carsystem.empresa.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ContatoEmpresaDto {

	private Long id;
	
	@NotNull(message = "Descrição não pode ser nula")
	@NotEmpty(message = "Descrição não pode ser em branco")
	@Length(min = 3, max = 45, message = "Descrição deve conter entre 3 e 45 caracteres.")
	private String descricao;
	
	@NotNull(message = "Contato não pode ser nulo")
	@NotEmpty(message = "Contato não pode ser em branco")
	private String contato;
	
	@NotNull(message = "Tipo não pode ser nulo")
	@NotEmpty(message = "Tipo não pode ser em branco")
	private String tipoContato;
	
	@NotNull(message = "ID da empresa não pode ser nulo")
	private Long empresa;
	
	public ContatoEmpresaDto() {}

	

	
	


	

	
	
}
