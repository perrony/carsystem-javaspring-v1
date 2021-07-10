package br.eti.scheffer.carsystem.empresa.services.impl;

import br.eti.scheffer.carsystem.empresa.dtos.ContatoEmpresaDto;
import br.eti.scheffer.carsystem.empresa.mapper.ContatoEmpresaMapper;
import br.eti.scheffer.carsystem.empresa.services.ContatoEmpresaService;
import br.eti.scheffer.core.entities.ContatoEmpresa;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.enums.TipoContato;
import br.eti.scheffer.core.exception.BadRequestException;

import br.eti.scheffer.core.repositories.ContatoEmpresaRepository;


import br.eti.scheffer.core.repositories.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;


@Service
@AllArgsConstructor
public class ContatoEmpresaServiceImpl implements ContatoEmpresaService {

	private final ContatoEmpresaRepository contatoEmpresaRepository;
	
	private final EmpresaRepository empresaRepository;

	
	@Override
	public List<ContatoEmpresa> listContatos(Long id) {
		Empresa empresa = this.findEmpresaByIdOrElseThrowBadRequestException(id);
		return empresa.getContato();
		
	}

	@Override
	public Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id) {
		return this.empresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Registro de Empresa não encontrado!"));
	}
	
	@Override
	public ContatoEmpresa findByIdOrElseThrowBadRequestException(Long id) {
		return this.contatoEmpresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Registro de contato não encontrado neste ID!"));
	}
	
	@Override
	public TipoContato validTipoOrElseBadRequestException(String tipo) {
		if(!EnumUtils.isValidEnum(TipoContato.class, tipo)) {
			throw new BadRequestException("Tipo Pessoa inválido");
		}
		return TipoContato.valueOf(tipo);
	}

	
	@Override
	public ContatoEmpresa findByDescricaoContainingIgnoreCase(String descricao) {
		return this.contatoEmpresaRepository.findByDescricaoContainingIgnoreCase(descricao);
	}

	@Override
	public ContatoEmpresa findByContatoContainingIgnoreCase(String contato) {
		return this.contatoEmpresaRepository.findByContatoContainingIgnoreCase(contato);
	}

	@Override
	public ContatoEmpresa save(ContatoEmpresaDto dto) {
		this.validTipoOrElseBadRequestException(dto.getTipoContato());
		return this.contatoEmpresaRepository.save(ContatoEmpresaMapper.toEntity(null,dto));
	}

	@Override
	public ContatoEmpresa update(ContatoEmpresaDto dto) {
		ContatoEmpresa contatoSalved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		Empresa empresa = this.findEmpresaByIdOrElseThrowBadRequestException(dto.getEmpresa());
		this.validTipoOrElseBadRequestException(dto.getTipoContato());
		contatoSalved.setEmpresa(empresa);
		return this.contatoEmpresaRepository.save(ContatoEmpresaMapper.toEntity(contatoSalved,dto));
	}

	@Override
	public void remover(Long id) {
		this.findByIdOrElseThrowBadRequestException(id);
		this.contatoEmpresaRepository.deleteById(id);
	}



	
}
