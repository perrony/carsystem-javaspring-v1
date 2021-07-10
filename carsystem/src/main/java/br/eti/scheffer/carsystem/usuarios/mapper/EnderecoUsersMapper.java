package br.eti.scheffer.carsystem.usuarios.mapper;

import br.eti.scheffer.carsystem.usuarios.dtos.EnderecoUsersDto;
import br.eti.scheffer.core.entities.EnderecoUsers;

public class EnderecoUsersMapper {
	
	
	public static EnderecoUsers toEntity(EnderecoUsers enderecoUsers, EnderecoUsersDto dto) {
		if(dto == null) {
			return null;
		}
		if(!(enderecoUsers instanceof EnderecoUsers)) {
			enderecoUsers = new EnderecoUsers();
		}

		enderecoUsers.setId(dto.getId());
		enderecoUsers.setDescricao(dto.getDescricao());
		enderecoUsers.setComplemento(dto.getComplemento());
		enderecoUsers.setNumero(dto.getNumero());
		enderecoUsers.setUnidade(dto.getUnidade());
		enderecoUsers.setIbge(dto.getIbge());
		enderecoUsers.setGia(dto.getGia());
		enderecoUsers.setCep(dto.getCep());
		enderecoUsers.setLogradouro(dto.getLogradouro());
		enderecoUsers.setBairro(dto.getBairro());
		enderecoUsers.setLocalidade(dto.getLocalidade());
		enderecoUsers.setUf(dto.getUf());
		enderecoUsers.setSiafi(dto.getSiafi());
	  
		return enderecoUsers;
	}

	public static EnderecoUsersDto entityToDto(EnderecoUsers enderecoUsers){
		if(enderecoUsers == null){
			return null;
		}
		EnderecoUsersDto dto = new EnderecoUsersDto();
		dto.setId(enderecoUsers.getId());
		dto.setDescricao(enderecoUsers.getDescricao());
		dto.setComplemento(enderecoUsers.getComplemento());
		dto.setNumero(enderecoUsers.getNumero());
		dto.setUsers(enderecoUsers.getUsers().getId());
		return dto;
	}

}
