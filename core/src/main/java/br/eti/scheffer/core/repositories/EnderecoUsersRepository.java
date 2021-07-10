package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.EnderecoUsers;
import br.eti.scheffer.core.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnderecoUsersRepository extends JpaRepository<EnderecoUsers, Long>{

    List<EnderecoUsers> findEnderecoUsersByUsers(Users users);

}
