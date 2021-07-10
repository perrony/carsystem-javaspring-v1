package br.eti.scheffer.carsystem.usuarios.mapper;

import br.eti.scheffer.carsystem.usuarios.dtos.RolesDto;
import br.eti.scheffer.core.entities.Roles;

import javax.validation.Valid;

public class RolesMapper {
	
	
	public static Roles toEntity(Roles roles, @Valid RolesDto dto) {
		if(dto == null) {
			return null;
		}
		if(!(roles instanceof Roles)) {
			 roles = new Roles();
		}
		roles.setId(dto.getId());
		roles.setRolesName(dto.getRolesName());
		return roles;
	}

	public static RolesDto entityToDto(Roles roles){
		if(roles == null){
			return null;
		}

		RolesDto dto = new RolesDto();
		dto.setId(roles.getId());
		dto.setRolesName(roles.getRolesName());
		return dto;
	}
}
