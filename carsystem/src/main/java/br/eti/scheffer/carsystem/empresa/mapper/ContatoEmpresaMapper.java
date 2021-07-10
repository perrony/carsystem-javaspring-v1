package br.eti.scheffer.carsystem.empresa.mapper;

import br.eti.scheffer.carsystem.empresa.dtos.ContatoEmpresaDto;
import br.eti.scheffer.core.entities.ContatoEmpresa;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.enums.TipoContato;

public class ContatoEmpresaMapper {


	
	 public static ContatoEmpresa toEntity(ContatoEmpresa contato, ContatoEmpresaDto dto) {
		 
		 if(dto == null) {
			 return null;
		 }
		 
		 if(!(contato instanceof ContatoEmpresa)) {
			 contato = new ContatoEmpresa();
		 }
	    	contato.setId(dto.getId());
		 	contato.setDescricao(dto.getDescricao());
	    	contato.setContato(dto.getContato());
	   		contato.setTipoContato(TipoContato.valueOf(dto.getTipoContato()));
	   		Empresa empresa = new Empresa();
	   		empresa.setId(dto.getEmpresa());
	   		contato.setEmpresa(empresa);
	    	return contato;
	    			
	 }

	 public static ContatoEmpresaDto entityToDto(ContatoEmpresa contato){
	 	if (contato == null){
	 		return null;
		}
		  ContatoEmpresaDto dto = new ContatoEmpresaDto();
	 	  dto.setId(contato.getId());
	 	  dto.setDescricao(contato.getDescricao());
	 	  dto.setTipoContato(contato.getTipoContato().toString());
	 	  dto.setContato(contato.getContato());
	 	  dto.setEmpresa(contato.getEmpresa().getId());
	 	  return dto;

	 }
}
