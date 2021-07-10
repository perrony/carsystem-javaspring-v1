package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, Long> {


    Optional<Users> findByCpfEquals(String cpf);

	Optional<Users> findByEmailEquals(String email);

	Page<Users> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

	Page<Users> findBySobrenomeContainingIgnoreCase(String sobrenome, Pageable pageable);

	Optional<Users> findByHashConfirmEquals(String hash);

	Optional<Users> findByUsernameEquals(String username);
}
