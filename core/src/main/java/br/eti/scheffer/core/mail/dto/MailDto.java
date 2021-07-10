package br.eti.scheffer.core.mail.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class MailDto {
	
	@NotEmpty(message = "Título do Email não pode ser vazio")
	@NotNull(message = "Título do Email não pode ser nulo")
	private String titulo;
	
	@NotEmpty(message = "Corpo do Email não pode ser vazio")
	@NotNull(message = "Corpo do Email não pode ser nulo")
	private String text;
	
	@NotEmpty(message = "Destinatário do Email não pode ser vazio")
	@NotNull(message = "Destinatário do Email não pode ser nulo")
	@Email(message = "Destinatário do Email é inválido")
	private String destinatario;
	
	@NotEmpty(message = "Remetente do Email não pode ser vazio")
	@NotNull(message = "Remetente do Email não pode ser nulo")
	@Email(message = "Remetente do Email é inválido")
	private String remetente;
	
	private String copiaCc;
	
	public MailDto() {}

}
