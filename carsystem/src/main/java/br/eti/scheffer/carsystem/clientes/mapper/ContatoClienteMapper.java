package br.eti.scheffer.carsystem.clientes.mapper;


import br.eti.scheffer.carsystem.clientes.dtos.ContatoClienteDto;
import br.eti.scheffer.core.entities.ContatoCliente;
import br.eti.scheffer.core.enums.TipoContato;
import org.apache.commons.lang3.EnumUtils;

import java.text.ParseException;

public class ContatoClienteMapper {
	
	 /**
	  * Converte um DTO para um objeto ContatoCliente
	  * 
	  * @param dto
	  * @return
	  * @throws ParseException
	  */
	 public static ContatoCliente toEntity(ContatoCliente contato, ContatoClienteDto dto) {
		 	if(dto == null) {
		 		return null;
		 	}
		 	if(!(contato instanceof ContatoCliente)) {
		 		contato = new ContatoCliente();
		 	}
		 	if((dto.getTipoContato() != null) && (EnumUtils.isValidEnum(TipoContato.class, dto.getTipoContato()))){
		 		contato.setTipoContato(TipoContato.valueOf(dto.getTipoContato()));
		 	}
	    	contato.setDescricao(dto.getDescricao());
	    	contato.setContato(dto.getContato());
	   	
	    	return contato;
	    			
	 }

}
