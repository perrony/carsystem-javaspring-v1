package br.eti.scheffer.carsystem.clientes.services;


import br.eti.scheffer.carsystem.clientes.dtos.ClientesDto;
import br.eti.scheffer.core.entities.Clientes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ClientesService {
	
	/**
	 * Lista de Clientes Pageable
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Clientes> listAll(Pageable pageable);
	
	/**
	 * Retorna um Cliente por cpf/cnpj
	 * 
	 * @param cnpjCpf
	 * @return
	 */
	Clientes findByCnpjCpf(String cnpjCpf);
	
	/**
	 * Retorna um optional Cliente pelo ID
	 * @param id
	 * @return
	 */
	Clientes findByIdOrThrowBadRequestException(Long id);

	
	/**
	 * Retorna uma lista de Clientes segundo pesquisa
	 * 
	 * @param razaoNome
	 * @return
	 */
	List<Clientes> findByrazaoNomeContainingIgnoreCase(String razaoNome);
	
	
	
	/**
	 * Retorna uma lista de Clientes segundo pesquisa
	 * 
	 * @param fantasiaApelido
	 * @return
	 */
	List<Clientes> findByfantasiaApelidoContainingIgnoreCase(String fantasiaApelido);
	
	
	/**
	 * Persiste um cliente na base de dados
	 * 
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	Clientes save(ClientesDto dto);
	
	/**
	 * Persiste um Cliente atualizado
	 * 
	 * @param dto
	 * @return
	 */
	Clientes update(ClientesDto dto);
	

}
