package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByRolesNameEquals(String rolesName);
}
