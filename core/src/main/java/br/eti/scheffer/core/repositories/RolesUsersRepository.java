package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.entities.RolesUsers;
import br.eti.scheffer.core.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesUsersRepository extends JpaRepository<RolesUsers, Long>{

	RolesUsers findByRolesAndUsers(Roles roles, Users users);

}
