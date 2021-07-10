package br.eti.scheffer.carsystem.empresa.services;

import br.eti.scheffer.carsystem.empresa.dtos.EmpresaDto;
import br.eti.scheffer.core.entities.Empresa;


public interface EmpresaService {

	Empresa findByIdOrElseThrowBadRequestException(Long id);

	Empresa findBycnpj(String cnpj);
	
	Empresa save(EmpresaDto dto);
	
	Empresa update(EmpresaDto dto);

	Empresa findFirstByOrderByIdAsc();

	
}
