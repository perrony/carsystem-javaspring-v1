package br.eti.scheffer.carsystem.clientes.services.impl;



import br.eti.scheffer.carsystem.clientes.dtos.ContatoClienteDto;
import br.eti.scheffer.carsystem.clientes.mapper.ContatoClienteMapper;
import br.eti.scheffer.carsystem.clientes.services.ContatoClienteService;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.ContatoCliente;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.repositories.ClientesRepository;
import br.eti.scheffer.core.repositories.ContatoClienteRepository;
import br.eti.scheffer.core.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ContatoClienteServiceImpl implements ContatoClienteService {

	@Autowired
	private ContatoClienteRepository contatoClienteRepository;

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users findUsersByIdOrThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado para este ID"));
	}

	@Override
	public Clientes findClientesByIdOrThrowBadRequestException(Long id) {
		return this.clientesRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Cliente não encontrado para este ID"));
	}
	
	@Override
	public ContatoCliente findByIdOrThrowBadRequestException(Long id) {
		return this.contatoClienteRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Contato não encontrado para este ID"));
	}
	
	@Override
	public ContatoCliente findByDescricao(String descricao) {
		return this.contatoClienteRepository.findBydescricao(descricao)
		.orElse(null);
		
	}

	@Override
	public ContatoCliente findByContato(String contato) {
		return this.contatoClienteRepository.findBycontato(contato)
				.orElse(null);
	}

	@Override
	@Transactional
	public ContatoCliente save(ContatoClienteDto dto){
		Users users = this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		Clientes cliente = this.findClientesByIdOrThrowBadRequestException(dto.getCliente());
		if(this.findByContato(dto.getContato()) != null) {
			throw new BadRequestException("Já existe um contato registrado neste valor");
		}
		ContatoCliente contato = ContatoClienteMapper.toEntity(null,dto);
		contato.setUsers(users);
		contato.setClientes(cliente);
		return this.contatoClienteRepository.saveAndFlush(contato);
				
	
	}
	
	@Override
	@Transactional
	public ContatoCliente update(ContatoClienteDto dto){
		ContatoCliente contatoSalved = this.findByIdOrThrowBadRequestException(dto.getId());
		Users users = this.findUsersByIdOrThrowBadRequestException(dto.getUsers());
		Clientes cliente = this.findClientesByIdOrThrowBadRequestException(dto.getCliente());
		if(contatoSalved.getContato() != dto.getContato()) {
			ContatoCliente contato = this.findByContato(dto.getContato());
			if(contato != null) {
				throw new BadRequestException("Já existe um contato registrado neste valor");
			}
		}
		contatoSalved.setUsers(users);
		contatoSalved.setClientes(cliente);
		
		return this.contatoClienteRepository.saveAndFlush(ContatoClienteMapper.toEntity(contatoSalved, dto));
		
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.findByIdOrThrowBadRequestException(id);
		this.contatoClienteRepository.deleteById(id);
	}

	
	
	

}
