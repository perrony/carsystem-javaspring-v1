package br.eti.scheffer.carsystem.usuarios.mapper;

import br.eti.scheffer.carsystem.usuarios.dtos.UsersDto;
import br.eti.scheffer.core.entities.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UsersMapper {
	

	public static Users toEntity(Users users, UsersDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		if(!(users instanceof Users)) {
			users = new Users();
		}
		
		users.setId(dto.getId());
		String password = !dto.getPassword().isEmpty() ? dto.getPassword().get() : "";
		if(!dto.getPassword().isEmpty()) {
		   users.setPassword(new BCryptPasswordEncoder().encode(password)); 
	    }
		users.setNome(dto.getNome());
		users.setSobrenome(dto.getSobrenome());
		users.setCpf(dto.getCpf());
		users.setEmail(dto.getEmail());
		users.setConfirmed(dto.isConfirmed());
		users.setHashConfirm(dto.getHashConfirm());
		users.setAtivo(dto.isAtivo());
		return users;
		
	}

	public static UsersDto entityToDto(Users users){
		if(!(users instanceof Users)){
			return null;
		}

		UsersDto dto = new UsersDto();
		dto.setId(users.getId());
		dto.setPassword(Optional.of(users.getPassword()));
		dto.setNome(users.getNome());
		dto.setSobrenome(users.getSobrenome());
		dto.setCpf(users.getCpf());
		dto.setEmail(users.getEmail());
		dto.setConfirmed(users.isConfirmed());
		dto.setHashConfirm(users.getHashConfirm());
		dto.setAtivo(users.isAtivo());
		dto.setEmpresa(users.getEmpresa().getId());
		return dto;

	}

}
