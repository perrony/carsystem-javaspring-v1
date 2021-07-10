package br.eti.scheffer.carsystem.usuarios.services.impl;

import br.eti.scheffer.carsystem.usuarios.dtos.EnderecoUsersDto;
import br.eti.scheffer.carsystem.usuarios.mapper.EnderecoUsersMapper;
import br.eti.scheffer.carsystem.usuarios.services.EnderecoUsersService;
import br.eti.scheffer.core.entities.EnderecoUsers;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.repositories.EnderecoUsersRepository;
import br.eti.scheffer.core.repositories.UsersRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoUsersServiceImpl implements EnderecoUsersService {

	@Autowired
	private EnderecoUsersRepository enderecoUsersRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<EnderecoUsers> findEnderecoUsersByUsers(Long id) {
		return this.enderecoUsersRepository.findEnderecoUsersByUsers(this.findUsersByIdOrElseThrowBadRequestException(id));
	}


	@Override
	public EnderecoUsers findByIdOrElseThrowBadRequestException(Long id) {
		return this.enderecoUsersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Endereço de usuário não encontrado!"));
				
	}

	@Override
	public Users findUsersByIdOrElseThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado!"));
	}

	@Override
	public EnderecoUsers save(EnderecoUsersDto dto) {
		EnderecoUsers enderecoUsers = EnderecoUsersMapper.toEntity(null, dto);
		enderecoUsers.setUsers(this.findUsersByIdOrElseThrowBadRequestException(dto.getUsers()));
		return this.enderecoUsersRepository.save(enderecoUsers);
	}

	@Override
	public EnderecoUsers update(EnderecoUsersDto dto) {
		EnderecoUsers enderecoUsersSalved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		enderecoUsersSalved.setUsers(this.findUsersByIdOrElseThrowBadRequestException(dto.getUsers()));
		return this.enderecoUsersRepository.save(EnderecoUsersMapper.toEntity(enderecoUsersSalved, dto));
	}

	@Override
	public void remove(Long id) {
		this.findByIdOrElseThrowBadRequestException(id);
		this.enderecoUsersRepository.deleteById(id);
		
	}


	

}
