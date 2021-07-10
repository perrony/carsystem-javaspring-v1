package br.eti.scheffer.core.repositories;


import br.eti.scheffer.core.entities.ContatoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ContatoClienteRepository extends  JpaRepository<ContatoCliente, Long>{

	Optional<ContatoCliente> findBydescricao(String descricao);
	
	Optional<ContatoCliente> findBycontato(String contato);
	
}
