package br.eti.scheffer.carsystem.usuarios.services.impl;

import br.eti.scheffer.carsystem.usuarios.services.RolesUsersService;
import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.entities.RolesUsers;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.repositories.RolesUsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesUsersServiceImpl implements RolesUsersService {

	@Autowired
	private RolesUsersRepository rolesUsersRepository;
	
	@Override
	public RolesUsers findByRolesAndUsers(Roles roles, Users users) {
		return this.rolesUsersRepository.findByRolesAndUsers(roles, users);
	}

	@Override
	public RolesUsers save(RolesUsers rolesUsers) {

		return this.rolesUsersRepository.save(rolesUsers);
	}

	@Override
	public void delete(Long id) {

		this.rolesUsersRepository.existsById(id);
	}

}
