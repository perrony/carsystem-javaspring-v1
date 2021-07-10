package br.eti.scheffer.carsystem.clientes.services;



import br.eti.scheffer.carsystem.clientes.dtos.ContatoClienteDto;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.ContatoCliente;
import br.eti.scheffer.core.entities.Users;


public interface ContatoClienteService {
	
	Users findUsersByIdOrThrowBadRequestException(Long id);
	
	Clientes findClientesByIdOrThrowBadRequestException(Long id);
	
	ContatoCliente findByIdOrThrowBadRequestException(Long id);
	
	ContatoCliente findByDescricao(String descricao);
	
	ContatoCliente findByContato(String contato);

	ContatoCliente save(ContatoClienteDto dto);
	
	ContatoCliente update(ContatoClienteDto dto);
	
	void  remover(Long id);
	

}
