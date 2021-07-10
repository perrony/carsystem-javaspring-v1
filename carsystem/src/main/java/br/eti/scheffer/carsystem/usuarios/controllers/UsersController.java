package br.eti.scheffer.carsystem.usuarios.controllers;

import br.eti.scheffer.carsystem.usuarios.dtos.UsersDto;
import br.eti.scheffer.carsystem.usuarios.services.UsersService;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.response.Response;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsersController  {
	
	
	private final UsersService usersService;

	
    @GetMapping
    public ResponseEntity<Page<Users>> listaUsuarios(Pageable pageable){
    	return ResponseEntity.ok(this.usersService.listAll(pageable));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Response<Users>> findByMmail(@PathVariable("email") String email){
		Response<Users> response = new Response<Users>();
		response.setData(this.usersService.findByEmailEquals(email));
		return ResponseEntity.ok(response);
    }

	@GetMapping(value = "/username/{username}")
	public ResponseEntity<Response<Users>> findByUserName(@PathVariable("username") String username){
		Response<Users> response = new Response<Users>();
		Users users = this.usersService.findByUsernameEquals(username);
		if(users != null){
			response.getErrors().add("Usuario ja registrado com este username");
		}
		return ResponseEntity.ok(response);
	}
    
    @GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<Users>> findUserById(@PathVariable("id") Long id){
		Response<Users> response = new Response<Users>();
		response.setData(this.usersService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
    
	@PutMapping
	public ResponseEntity<Response<Users>> update(@Valid @RequestBody UsersDto dto)  {
		  Response<Users> response = new Response<Users>();
			Users usersSalved = this.usersService.update(dto);
			this.usersService.saveRoles(dto, usersSalved);
			response.setData(usersSalved);
			return ResponseEntity.ok(response);
	}
    
}
