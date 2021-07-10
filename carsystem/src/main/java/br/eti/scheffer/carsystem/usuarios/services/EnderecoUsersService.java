package br.eti.scheffer.carsystem.usuarios.services;

import br.eti.scheffer.carsystem.usuarios.dtos.EnderecoUsersDto;
import br.eti.scheffer.core.entities.EnderecoUsers;
import br.eti.scheffer.core.entities.Users;

import java.util.List;

public interface EnderecoUsersService {

	EnderecoUsers findByIdOrElseThrowBadRequestException(Long id);

	Users findUsersByIdOrElseThrowBadRequestException(Long id);
	
	List<EnderecoUsers> findEnderecoUsersByUsers(Long id);
	
	EnderecoUsers save(EnderecoUsersDto dto);
	
	EnderecoUsers update(EnderecoUsersDto dto);
	
	void remove(Long id);
	
}
