package br.eti.scheffer.carsystem.usuarios.services.impl;

import br.eti.scheffer.carsystem.usuarios.dtos.UsersDto;
import br.eti.scheffer.carsystem.usuarios.mapper.UsersMapper;
import br.eti.scheffer.carsystem.usuarios.services.RolesUsersService;
import br.eti.scheffer.carsystem.usuarios.services.UsersService;
import br.eti.scheffer.core.entities.*;
import br.eti.scheffer.core.exception.BadRequestException;

import br.eti.scheffer.core.mail.PreMail;
import br.eti.scheffer.core.mail.SendHtmlMail;
import br.eti.scheffer.core.mail.mailHtml;
import br.eti.scheffer.core.mail.resetHtml;
import br.eti.scheffer.core.repositories.EmpresaRepository;
import br.eti.scheffer.core.repositories.ParametersRepository;
import br.eti.scheffer.core.repositories.RolesRepository;
import br.eti.scheffer.core.repositories.UsersRepository;


import br.eti.scheffer.core.utils.PasswordUtils;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsersServiceImpl implements UsersService {

	@Autowired
	private  UsersRepository usersRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private  RolesUsersService rolesUsersService;

	@Autowired
	private  RolesRepository rolesRepository;

	@Autowired
	private  ParametersRepository parametersRepository;


	@Override
	public Page<Users> listAll(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}
	
	@Override
	public Users findByIdOrElseThrowBadRequestException(Long id) {
		return this.usersRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Usuário não encontrado"));
	}
	
	@Override
	public Empresa findEmpresaByIdOrElseThrowBadRequestException(Long id) {
		return this.empresaRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Empresa não identificada"));
	}

	@Override
	public Empresa findFirstEmpresaOrElseThrowBadRequestException() {
		return this.empresaRepository.findFirstByOrderByIdAsc()
				.orElseThrow(() -> new BadRequestException("Empresa nao definida"));
	}


	@Override
	public Users findByCpfEquals(String cpf) {
		return this.usersRepository.findByCpfEquals(cpf).orElse(null);
	}

	@Override
	public Users findByEmailEquals(String email) {
		return this.usersRepository.findByEmailEquals(email)
				.orElse(null);
	}

	@Override
	public Page<Users> findByNomeContainingIgnoreCase(String nome, Pageable pageable) {
		return this.usersRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

	@Override
	public Page<Users> findBySobrenomeContainingIgnoreCase(String sobrenome, Pageable pageable) {
		return this.usersRepository.findBySobrenomeContainingIgnoreCase(sobrenome, pageable);
	}

	@Override
	public Users findByHashConfirmEquals(String hash) {
		return this.usersRepository.findByHashConfirmEquals(hash)
				.orElseThrow(() -> new BadRequestException("Hash não encontrado"));
	}

	@Override
	public Users findByUsernameEquals(String username) {
		return this.usersRepository.findByUsernameEquals(username)
				.orElse(null);
	}

	@Override
	public Users save(UsersDto dto) {
		if(this.findByCpfEquals(dto.getCpf()) != null) {
			new BadRequestException("CPF já cadastrado para outro usuário");
		}
		Users users = UsersMapper.toEntity(null, dto);
		Optional<Empresa> empresa = this.empresaRepository.findFirstByOrderByIdAsc();
		users.setEmpresa(empresa.get());
		Parameters parameters = this.parametersRepository.findFirstByOrderByIdAsc();
		Users usersSalved = this.usersRepository.save(users);
		this.sendMail(empresa.get(),parameters,usersSalved,"Confirmaçao de Cadastro",mailHtml.mailText(empresa.get().getNomeFantasia(),usersSalved.getHashConfirm()));

		return usersSalved;
	}


	@Override
	public Users update(UsersDto dto) {
		Users usersSalved = this.findByIdOrElseThrowBadRequestException(dto.getId());
		if(dto.getCpf() != usersSalved.getCpf()) {
			if(this.findByCpfEquals(dto.getCpf()) != null) {
				new BadRequestException("CPF já cadastrado para outro usuário");
			}
		}
		Users usersUpdated = this.usersRepository.save(UsersMapper.toEntity(usersSalved, dto));
		if(!usersUpdated.isConfirmed()){
			Optional<Empresa> empresa = this.empresaRepository.findFirstByOrderByIdAsc();
			Parameters parameters = this.parametersRepository.findFirstByOrderByIdAsc();
			this.sendMail(empresa.get(),parameters,usersSalved,"Confirmaçao de Cadastro",mailHtml.mailText(empresa.get().getNomeFantasia(),usersSalved.getHashConfirm()));

		}
		return usersUpdated;
	}


	@Override
	public void resetPassword(UsersDto dto) {
		Users users = this.findByEmailEquals(dto.getEmail());
		if(users == null){
			throw new BadRequestException("Email nao cadastrado no sistema!");
		}
		Optional<Empresa> empresa = this.empresaRepository.findFirstByOrderByIdAsc();
		Parameters parameters = this.parametersRepository.findFirstByOrderByIdAsc();
		this.sendMail(empresa.get(),parameters,users,"Reset Senha", resetHtml.mailText(empresa.get().getNomeFantasia(),users.getHashConfirm()));

	}

	@Override
	public void remove(Long id) {
		this.usersRepository.delete(this.findByIdOrElseThrowBadRequestException(id));
	}

	
	@Override
	public void saveRoles(UsersDto dto, Users users){
		if(dto.getRoles() != null) {
		Iterator<JsonNode> iterator = dto.getRoles().elements(); 
		
		if(iterator != null) {
			while(iterator.hasNext()) {
				Long element = iterator.next().asLong();
				Optional<Roles> roles = this.rolesRepository.findById(element);
				if(roles.isPresent()) {
					RolesUsers rolesUsers = this.rolesUsersService.findByRolesAndUsers(roles.get(),users);
					if(rolesUsers != null) {
						RolesUsers rolesUsersNew = new RolesUsers();
						rolesUsersNew.setUsers(users);
						rolesUsersNew.setRoles(roles.get());
						this.rolesUsersService.save(rolesUsersNew);
					}
				 }
			  }
		   }
	    }
	 }


	@Override
	public void sendMail(Empresa empresa, Parameters parameters, Users users, String subject, String bodyHtml) {

		String password = PasswordUtils.decode64(parameters.getPassword());
		PreMail preMail = PreMail.builder()
				.nameFrom(empresa.getNomeFantasia())
				.addressFrom(parameters.getAddressFrom())
				.nameTo(users.getNome() + " " + users.getSobrenome())
				.addressTo(users.getEmail())
				.smtp(parameters.getSmtp())
				.port(parameters.getPort())
				.username(parameters.getUsername())
				.password(password)
				.bodyHtml(bodyHtml)
				.subject(subject)
				.build();

		SendHtmlMail mail = new SendHtmlMail();
		mail.send(preMail);
	}

}
