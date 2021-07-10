package br.eti.scheffer.carsystem.usuarios.services;

import br.eti.scheffer.carsystem.usuarios.dtos.UsersDto;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.entities.Parameters;
import br.eti.scheffer.core.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Parameter;


public interface UsersService {
	
	Users findByIdOrElseThrowBadRequestException(Long id);
	
	Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id);

	Empresa findFirstEmpresaOrElseThrowBadRequestException();

	Users findByCpfEquals(String cpf);

	Users findByEmailEquals(String email);

	Page<Users> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

	Page<Users> findBySobrenomeContainingIgnoreCase(String sobrenome, Pageable pageable);
	
	Page<Users> listAll(Pageable pageable);
	
	Users findByHashConfirmEquals(String hash);
	
	Users findByUsernameEquals(String username);
	
	Users save(UsersDto dto);
	
	Users update(UsersDto dto);

	void resetPassword(UsersDto dto);

	void remove(Long id);

	void saveRoles(UsersDto dto, Users users);

	void sendMail(Empresa empresa, Parameters parameters, Users users, String subject,String bodyHtml);

	

}
