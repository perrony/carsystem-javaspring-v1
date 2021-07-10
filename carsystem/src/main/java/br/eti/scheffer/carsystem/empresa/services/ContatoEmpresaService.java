package br.eti.scheffer.carsystem.empresa.services;

import br.eti.scheffer.carsystem.empresa.dtos.ContatoEmpresaDto;
import br.eti.scheffer.core.entities.ContatoEmpresa;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.enums.TipoContato;

import java.util.List;


public interface ContatoEmpresaService {
	
	List<ContatoEmpresa> listContatos(Long id);

	Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id);
	
	ContatoEmpresa findByIdOrElseThrowBadRequestException(Long id);

	TipoContato validTipoOrElseBadRequestException(String tipo);
	
	ContatoEmpresa findByDescricaoContainingIgnoreCase(String descricao);
	
	ContatoEmpresa findByContatoContainingIgnoreCase(String contato);
	
    ContatoEmpresa save(ContatoEmpresaDto dto);
	 
    ContatoEmpresa update(ContatoEmpresaDto dto);
	
	void  remover(Long id);
}
