package br.eti.scheffer.carsystem.clientes.services;

import br.eti.scheffer.carsystem.clientes.dtos.EnderecoClientesDto;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.EnderecoClientes;
import br.eti.scheffer.core.entities.Users;

import java.util.List;

public interface EnderecoClientesService {
	
	List<EnderecoClientes> listAll(Long id);

	Clientes findClientesByIdOrThrwoNewBadRequestException(Long id);
	
	EnderecoClientes findByIdOrThrowNewBadRequestException(Long id);

	Users findUsersByIdOrThrowBadRequestException(Long id);
	
	EnderecoClientes save(EnderecoClientesDto dto);
	
	EnderecoClientes update(EnderecoClientesDto dto);
	
	void remover(Long id);
	
}
