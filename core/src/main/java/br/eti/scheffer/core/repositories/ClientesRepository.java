package br.eti.scheffer.core.repositories;


import br.eti.scheffer.core.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ClientesRepository extends JpaRepository<Clientes, Long>{
	
	Optional<Clientes> findBycnpjCpf(String cnpjCpf);
	
	List<Clientes> findByrazaoNomeContainingIgnoreCase(String razaoNome);
	
	List<Clientes> findByfantasiaApelidoContainingIgnoreCase(String fantasiaApelido);
	

}

