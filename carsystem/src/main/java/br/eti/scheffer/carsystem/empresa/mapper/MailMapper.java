package br.eti.scheffer.carsystem.empresa.mapper;

import br.eti.scheffer.carsystem.empresa.dtos.ContatoEmpresaDto;
import br.eti.scheffer.carsystem.empresa.mail.MailHtml;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.mail.dto.MailDto;



public class MailMapper {

	public static MailDto validaMail(Empresa empresa, ContatoEmpresaDto dto) {
		MailDto mailDto = new MailDto();
		mailDto.setTitulo("Confirmação de Email");
		mailDto.setRemetente("scheffer.consultoria@gmail.com");
		mailDto.setDestinatario(dto.getContato());
		mailDto.setText(MailHtml.mailText(empresa.getRazaoSocial()));
		return mailDto;
		
	}

}
