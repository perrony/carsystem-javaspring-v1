package br.eti.scheffer.carsystem.clientes.services.impl;


import br.eti.scheffer.carsystem.clientes.dtos.ClientesDto;
import br.eti.scheffer.carsystem.clientes.mapper.ClientesMapper;
import br.eti.scheffer.carsystem.clientes.services.ClientesService;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.repositories.ClientesRepository;
import br.eti.scheffer.core.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	
	public Users findUsersByIdOrThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado!"));
	}
	
	@Override
	public Clientes findByIdOrThrowBadRequestException(Long id) {
		return this.clientesRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Cliente não encontrado!"));
		
	}
	
	
	
	@Override
	public Page<Clientes> listAll(Pageable pageable) {
		return this.clientesRepository.findAll(pageable);
	}
	
	/**
	 * Retorna um Cliente pelo CPF/CNPJ
	 */
	public Clientes findByCnpjCpf(String cnpjCpf) {
		return this.clientesRepository.findBycnpjCpf(cnpjCpf).orElse(null);
				
		
	}
	
	
	@Override
	public List<Clientes> findByrazaoNomeContainingIgnoreCase(String razaoNome) {
		return (List<Clientes>) this.clientesRepository.findByrazaoNomeContainingIgnoreCase(razaoNome);
	}

	

	
	@Override
	public List<Clientes> findByfantasiaApelidoContainingIgnoreCase(String fantasiaApelido) {
		return (List<Clientes>) this.clientesRepository.findByfantasiaApelidoContainingIgnoreCase(fantasiaApelido);
		
	}

	@Override
	@Transactional
	public Clientes save(ClientesDto dto) {
		log.info("Persistindo cliente");
		this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		Clientes clienteByCnpj = this.findByCnpjCpf(dto.getCnpjCpf());
		if(clienteByCnpj != null) {
			throw new BadRequestException("Cliente já cadastrado com este CPF ou CNPJ");
		}
			
		return this.clientesRepository.save(ClientesMapper.toEntity(null,dto));
		 
	}

	@Override
	@Transactional
	public Clientes update(ClientesDto dto) {
		this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		Clientes clienteSaved = this.findByIdOrThrowBadRequestException(dto.getId());

		if(!clienteSaved.getCnpjCpf().equals(dto.getCnpjCpf())){

			Clientes clienteByCnpj = this.findByCnpjCpf(dto.getCnpjCpf());
			if(clienteByCnpj != null) {
				throw new BadRequestException("Cliente já cadastrado com este CPF ou CNPJ");
			}
		}
		return this.clientesRepository.save(ClientesMapper.toEntity(clienteSaved,dto));
	}


}
