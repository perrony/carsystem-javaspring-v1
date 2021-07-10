package br.eti.scheffer.carsystem.empresa.services;

import br.eti.scheffer.carsystem.empresa.dtos.EnderecoEmpresaDto;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.entities.EnderecoEmpresa;
import br.eti.scheffer.core.entities.Users;

public interface EnderecoEmpresaService {

	Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id);
	
	Users findUsersByIdOrElseThrowBadRequestException(Long id);

	EnderecoEmpresa findByIdOrElseThrowBadRequestException(Long id);
	
	EnderecoEmpresa save(EnderecoEmpresaDto dto);
	
	EnderecoEmpresa update(EnderecoEmpresaDto dto);
	
	void remover(Long id);
}
