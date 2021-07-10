package br.eti.scheffer.carsystem.usuarios.mapper;

import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.mail.dto.MailDto;


public class MailMapper {
	
	
	public static MailDto validaMail(Empresa empresa, Users users) {
		MailDto mailDto = new MailDto();
		mailDto.setTitulo("Confirmação de Email");
		mailDto.setRemetente("scheffer.consultoria@gmail.com");
		mailDto.setDestinatario(users.getEmail());
//		mailDto.setText(mailHtml.mailText(users.getHashConfirm(), empresa.getRazaoSocial()));
		return mailDto;
		
	}

}
