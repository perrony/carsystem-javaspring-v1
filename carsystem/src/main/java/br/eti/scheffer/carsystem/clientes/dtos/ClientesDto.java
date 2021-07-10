package br.eti.scheffer.carsystem.clientes.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class ClientesDto {
	
	private Long id;
	
	@NotEmpty(message = "Tipo Pessoa não pode ser vazio!")
	@NotNull(message = "Tipo Pessoa não pode ser vazio!")
	private String tipoPessoa;
	
	@NotEmpty(message = "Nome ou Razão Social não pode ser vazio")
	@NotNull(message = "Nome ou Razão Social não pode ser vazio")
	private String razaoNome;
	
	private String cnpjCpf;
	private String rgIe;
	private String fantasiaApelido;
	private Date nascimento;
	
	@NotEmpty(message = "Sexo não pode ser vazio!")
	@NotNull(message = "Sexo não pode ser vazio!")
	private String sexo;
	@NotNull(message = "Usuário não pode ser vazio!")
	private Long users;
	private Long endereco;
	
	private Boolean ativo = false;

	public ClientesDto() {}

	
	public String setSexo(String sexo) {
		this.sexo = sexo;
		if(sexo == "") {
			this.sexo = "NAO_INFORMADO";
		}
		return this.sexo;
	}
	
	
	
}
