package br.eti.scheffer.carsystem.empresa.services.impl;

import br.eti.scheffer.carsystem.empresa.dtos.EmpresaDto;
import br.eti.scheffer.carsystem.empresa.mapper.EmpresaMapper;
import br.eti.scheffer.carsystem.empresa.services.EmpresaService;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.exception.BadRequestException;


import br.eti.scheffer.core.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;


	@Override
	public Empresa findFirstByOrderByIdAsc() {
		return this.empresaRepository.findFirstByOrderByIdAsc()
				.orElseThrow(() -> new BadRequestException("Empresa nao definida"));
	}


	@Override
	public Empresa findByIdOrElseThrowBadRequestException(Long id) {
		return this.empresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Empresa não encontrada!"));
				
	}

	@Override
	public Empresa findBycnpj(String cnpj) {
		return this.empresaRepository.findBycnpj(cnpj)
				.orElseThrow(() -> new BadRequestException("Empresa não definida!"));
		
	}

	@Override
	public Empresa save(EmpresaDto dto) {
		return this.empresaRepository.save(EmpresaMapper.toEntity(null,dto));
	}

	@Override
	public Empresa update(EmpresaDto dto) {
		Empresa empresaSaved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		return this.empresaRepository.save(EmpresaMapper.toEntity(empresaSaved,dto));
	}




}
