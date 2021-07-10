package br.eti.scheffer.carsystem.empresa.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@ToString
public class EmpresaDto {

	private Long id;
	
	@NotEmpty(message = "Razão Social não pode ser vazio.")
	@Length(min = 10, max = 255, message = "Razão social deve ter entre 10 e 255 caracteres.")
	private String razaoSocial;
	
	@NotEmpty(message = "Nome Fantasia não pode ser vazio.")
	@Length(min = 10, max = 255, message = "Nome Fantasia deve ter entre 10 e 255 caracteres.")
	private String nomeFantasia;
	
	@NotEmpty(message = "Cnpj não pode ser vazio.")
	@CNPJ(message = "Cnpj inválido")
	private String cnpj;
	
	@NotEmpty(message = "Inscrição estadual não pode ser vazio.")
	private String inscricaoEstadual;
	private Date dataAbertura;
	private String webSite;
	private Long endereco;
	
	public EmpresaDto() {
	
	}



	
}
