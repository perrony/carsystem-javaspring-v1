package br.eti.scheffer.carsystem.usuarios.dtos;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Getter
@Setter
@ToString
public class UsersDto {

	
	private Long id;

	@NotEmpty(message = "Nome do usuário não pode ser vazio!")
	@Length(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "Sobrenome do usuário não pode ser vazio!")
	@Length(min = 3, max = 100, message = "O sobrenome deve ter entre 3 e 100 caracteres")
	private String sobrenome;
	
	@CPF(message = "CPF Inválido")
	private String cpf;
	
	@Email(message = "Email inválido")
	private String email;
	private boolean confirmed = false;
	private boolean ativo = false;
	private String hashConfirm;
	private Optional<String> password = Optional.empty();
	
	private Long empresa;
	
	private JsonNode roles;
	
	public UsersDto() {}

	

	

	

	

	

	


	
	
	
	
	
}
