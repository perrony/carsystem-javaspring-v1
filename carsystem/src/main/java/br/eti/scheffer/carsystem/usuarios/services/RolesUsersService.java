package br.eti.scheffer.carsystem.usuarios.services;

import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.entities.RolesUsers;
import br.eti.scheffer.core.entities.Users;

public interface RolesUsersService {
	
	
	RolesUsers findByRolesAndUsers(Roles roles, Users users);
	
	RolesUsers save(RolesUsers rolesUsers);

	void delete(Long id);

}
