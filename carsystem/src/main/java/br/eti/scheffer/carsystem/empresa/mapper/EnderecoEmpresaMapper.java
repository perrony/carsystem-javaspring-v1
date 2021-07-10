package br.eti.scheffer.carsystem.empresa.mapper;

import br.eti.scheffer.carsystem.empresa.dtos.EnderecoEmpresaDto;
import br.eti.scheffer.core.entities.EnderecoEmpresa;

public class EnderecoEmpresaMapper {
	

	public static EnderecoEmpresa toEntity(EnderecoEmpresa enderecoEmpresa, EnderecoEmpresaDto dto) {
		if(dto == null) {
			return null;
		}
		
		if(!(enderecoEmpresa instanceof EnderecoEmpresa)) {
			enderecoEmpresa = new EnderecoEmpresa();
		}

		enderecoEmpresa.setId(dto.getId());
		enderecoEmpresa.setDescricao(dto.getDescricao());
		enderecoEmpresa.setComplemento(dto.getComplemento());
		enderecoEmpresa.setNumero(dto.getNumero());
		enderecoEmpresa.setUnidade(dto.getUnidade());
		enderecoEmpresa.setIbge(dto.getIbge());
		enderecoEmpresa.setGia(dto.getGia());
		enderecoEmpresa.setCep(dto.getCep());
		enderecoEmpresa.setLogradouro(dto.getLogradouro());
		enderecoEmpresa.setBairro(dto.getBairro());
		enderecoEmpresa.setLocalidade(dto.getLocalidade());
		enderecoEmpresa.setUf(dto.getUf());
		enderecoEmpresa.setSiafi(dto.getSiafi());
		return enderecoEmpresa;
		
	}
}
