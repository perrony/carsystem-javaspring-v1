package br.eti.scheffer.carsystem.usuarios.services.impl;

import br.eti.scheffer.carsystem.usuarios.dtos.RolesDto;
import br.eti.scheffer.carsystem.usuarios.mapper.RolesMapper;
import br.eti.scheffer.carsystem.usuarios.services.RolesService;
import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.repositories.RolesRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Page<Roles> listAllRoles(Pageable pageable) {

		return this.rolesRepository.findAll(pageable);
	}

	@Override
	public List<Roles> listAllRolesNotPageable() {
		return this.rolesRepository.findAll();
	}

	@Override
	public Roles findByIdOrElseThrowBadRequestException(Long id) {
		return this.rolesRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Role não encontrada neste ID"));
	}
	
	@Override
	public Optional<Roles> findByRolesNameEquals(String rolesName) {
		return this.rolesRepository.findByRolesNameEquals(rolesName);
				
	}

	@Override
	public Optional<Roles> findBynomeOrNull(String rolesName) {
		return this.rolesRepository.findByRolesNameEquals(rolesName);
	}
	
	@Override
	@Transactional
	public Roles save(RolesDto dto) {
		if(this.rolesRepository.findByRolesNameEquals(dto.getRolesName()).isPresent()) {
			throw new BadRequestException("Role já cadastrada com neste nome. ");
		}
		return this.rolesRepository.save(RolesMapper.toEntity(null, dto));
	}

	@Override
	@Transactional
	public Roles update(RolesDto dto) {
		Roles rolesSalved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		if(rolesSalved.getRolesName() != dto.getRolesName()) {
			if(!this.rolesRepository.findByRolesNameEquals(dto.getRolesName()).isPresent()) {
				throw new BadRequestException("Role já cadastrada com neste nome. ");
			}
		}
		return this.rolesRepository.save(RolesMapper.toEntity(rolesSalved, dto));
	}
	
	@Override
	@Transactional
	public void remove(Long id) {
		this.findByIdOrElseThrowBadRequestException(id);
		this.rolesRepository.deleteById(id);
		
	}




}
