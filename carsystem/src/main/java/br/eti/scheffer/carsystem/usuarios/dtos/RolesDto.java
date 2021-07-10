package br.eti.scheffer.carsystem.usuarios.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class RolesDto {
	
	private Long id;

	@NotNull
	@NotEmpty(message = "Nome da regra é obrigatório")
	@Length(min = 3, max = 25, message = "Nome da regra deve ficar entre 3 e 25 caracteres")
	private String rolesName;

	public RolesDto() {}

	
	
	
}
