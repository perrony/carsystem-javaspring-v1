package br.eti.scheffer.carsystem.usuarios.services;

import br.eti.scheffer.carsystem.usuarios.dtos.RolesDto;
import br.eti.scheffer.core.entities.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface RolesService {

	Page<Roles> listAllRoles(Pageable pageable);
	
	Roles findByIdOrElseThrowBadRequestException(Long id);
	
	Optional<Roles> findByRolesNameEquals(String rolesName);
	
	Optional<Roles> findBynomeOrNull(String rolesName);
	
	Roles save(RolesDto dto);
	
	Roles update(RolesDto dto);
	
	void remove(Long id);

    List<Roles> listAllRolesNotPageable();

}
