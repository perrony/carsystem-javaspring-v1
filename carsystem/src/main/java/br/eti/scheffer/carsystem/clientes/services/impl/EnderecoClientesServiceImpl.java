package br.eti.scheffer.carsystem.clientes.services.impl;



import br.eti.scheffer.carsystem.clientes.dtos.EnderecoClientesDto;
import br.eti.scheffer.carsystem.clientes.mapper.EnderecoClientesMapper;
import br.eti.scheffer.carsystem.clientes.services.EnderecoClientesService;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.EnderecoClientes;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.repositories.ClientesRepository;
import br.eti.scheffer.core.repositories.EnderecoClientesRepository;
import br.eti.scheffer.core.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoClientesServiceImpl implements EnderecoClientesService {

	private EnderecoClientesRepository enderecoClientesRepository;

	private UsersRepository usersRepository;
	
	private ClientesRepository clientesRepository;
	
	
	@Override
	public List<EnderecoClientes> listAll(Long id) {
		return this.findClientesByIdOrThrwoNewBadRequestException(id).getEnderecos();
	}
	
	@Override
	public EnderecoClientes findByIdOrThrowNewBadRequestException(Long id) {
		return this.enderecoClientesRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Endereço de Cliente não encontrado!"));
	}
	
	@Override
	public Clientes findClientesByIdOrThrwoNewBadRequestException(Long id) {
		return this.clientesRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Cliente não encontrado!"));
	}

	@Override
	public Users findUsersByIdOrThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado para este ID"));
	}

	
	@Override
	public EnderecoClientes save(EnderecoClientesDto dto) {
		Clientes cliente = this.findClientesByIdOrThrwoNewBadRequestException(dto.getClientes());
		Users users = this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		EnderecoClientes enderecoCliente = EnderecoClientesMapper.toEntity(null,dto);
		enderecoCliente.setClientes(cliente);
		enderecoCliente.setUsers(users);
		return this.enderecoClientesRepository.saveAndFlush(enderecoCliente);
		
	}

	@Override
	public EnderecoClientes update(EnderecoClientesDto dto) {
		EnderecoClientes enderecoSalved = this.findByIdOrThrowNewBadRequestException(dto.getId());
		Clientes cliente = this.findClientesByIdOrThrwoNewBadRequestException(dto.getClientes());
		Users users = this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		enderecoSalved.setClientes(cliente);
		enderecoSalved.setUsers(users);
		return this.enderecoClientesRepository.saveAndFlush( EnderecoClientesMapper.toEntity(enderecoSalved,dto));
		
	}

	@Override
	public void remover(Long id) {
		this.findByIdOrThrowNewBadRequestException(id);
		this.enderecoClientesRepository.deleteById(id);
		
	}

	
	


}
