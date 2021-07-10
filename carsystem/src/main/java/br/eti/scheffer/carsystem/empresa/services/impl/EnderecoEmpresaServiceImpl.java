package br.eti.scheffer.carsystem.empresa.services.impl;

import br.eti.scheffer.carsystem.empresa.dtos.EnderecoEmpresaDto;
import br.eti.scheffer.carsystem.empresa.mapper.EnderecoEmpresaMapper;
import br.eti.scheffer.carsystem.empresa.services.EnderecoEmpresaService;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.entities.EnderecoEmpresa;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;

import br.eti.scheffer.core.repositories.EmpresaRepository;
import br.eti.scheffer.core.repositories.EnderecoEmpresaRepository;
import br.eti.scheffer.core.repositories.UsersRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EnderecoEmpresaServiceImpl implements EnderecoEmpresaService {

	@Autowired
	private EnderecoEmpresaRepository enderecoEmpresaRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id) {
		return this.empresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Empresa não definida neste ID"));
	}

	@Override
	public Users findUsersByIdOrElseThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado neste ID"));
	}


	@Override
	public EnderecoEmpresa findByIdOrElseThrowBadRequestException(Long id) {
		return this.enderecoEmpresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Endereço não encontrado neste ID"));
		
	}

	@Override
	@Transactional
	public EnderecoEmpresa save(EnderecoEmpresaDto dto) {
		EnderecoEmpresa endereco = EnderecoEmpresaMapper.toEntity(null,dto);
		endereco.setUsers(this.findUsersByIdOrElseThrowBadRequestException(dto.getUsers()));
		endereco.setEmpresa(this.findEmpresaByIdOrElseThrowBadRequestException(dto.getEmpresa()));
		return this.enderecoEmpresaRepository.save(endereco);
		
	}

	@Override
	@Transactional
	public EnderecoEmpresa update(EnderecoEmpresaDto dto) {
		EnderecoEmpresa enderecoSalved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		enderecoSalved.setUsers(this.findUsersByIdOrElseThrowBadRequestException(dto.getUsers()));
		enderecoSalved.setEmpresa(this.findEmpresaByIdOrElseThrowBadRequestException(dto.getEmpresa()));
		return this.enderecoEmpresaRepository.save(EnderecoEmpresaMapper.toEntity(enderecoSalved, dto));
	}

	@Override
	@Transactional
	public void remover(Long id) {
		this.findByIdOrElseThrowBadRequestException(id);
		this.enderecoEmpresaRepository.deleteById(id);
		
	}
	
	
}
