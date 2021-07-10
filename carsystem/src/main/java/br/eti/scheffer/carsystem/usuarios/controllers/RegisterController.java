package br.eti.scheffer.carsystem.usuarios.controllers;

import br.eti.scheffer.carsystem.usuarios.dtos.UsersDto;
import br.eti.scheffer.carsystem.usuarios.services.RolesService;
import br.eti.scheffer.carsystem.usuarios.services.UsersService;
import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.response.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService rolesService;
	
	public RegisterController() {}

	
	@GetMapping(value = "/rolesname/{role}")
	public ResponseEntity<Response<Optional<Roles>>> findRuleName(@PathVariable("role") String role){
		Response<Optional<Roles>> response = new Response<Optional<Roles>>();
		response.setData(this.rolesService.findByRolesNameEquals(role));
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/finduserhash/{hash}")
	public ResponseEntity<Response<Users>> findHashReset(@PathVariable("hash") String hash){
		Response<Users> response = new Response<>();
		response.setData(this.usersService.findByHashConfirmEquals(hash));
		return ResponseEntity.ok(response);
	}
	
   @GetMapping(value = "/email/{email}")
   public ResponseEntity<Response<Users>> existsEmail(@PathVariable("email") String email){
		Response<Users> response = new Response<Users>();
		response.setData(this.usersService.findByEmailEquals(email));
   		return ResponseEntity.ok(response);
   }
       
	
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Response<Users>> findByCpf(@PathVariable("cpf") String cpf){
		Response<Users> response = new Response<Users>();
		response.setData(this.usersService.findByCpfEquals(cpf));
		return ResponseEntity.ok(response);
    }
	
 
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Response<Users>> findByUserName(@PathVariable("username") String username){
		Response<Users> response = new Response<Users>();
		response.setData(this.usersService.findByUsernameEquals(username));
		return ResponseEntity.ok(response);
    }
	
	
	@PostMapping
	public ResponseEntity<Response<Users>> cadastrar(@Valid @RequestBody UsersDto dto)  {
		Response<Users> response = new Response<Users>();
			response.setData(this.usersService.save(dto));
			return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/reset")
	public ResponseEntity<String> reset(@RequestBody UsersDto dto)  {
		this.usersService.resetPassword(dto);
		return ResponseEntity.ok("Email enviado para redefiniçao de senha");
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
