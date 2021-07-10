package br.eti.scheffer.carsystem.usuarios.controllers;

import br.eti.scheffer.carsystem.usuarios.dtos.EnderecoUsersDto;
import br.eti.scheffer.carsystem.usuarios.services.EnderecoUsersService;
import br.eti.scheffer.core.entities.EnderecoUsers;
import br.eti.scheffer.core.response.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/enderecousers")
public class EnderecoUsersController {
	
	
	@Autowired
	private EnderecoUsersService enderecoUsersService;
	
	@GetMapping(value = "/users/{id}")
	public List<EnderecoUsers> listEnderecoUsers(@PathVariable("id") Long id) {


		return this.enderecoUsersService.findEnderecoUsersByUsers(id);
	}


	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<EnderecoUsers>> findEnderecoUsersById(@PathVariable("id") Long id){
		Response<EnderecoUsers> response = new Response<EnderecoUsers>();
		response.setData(this.enderecoUsersService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
	
	
	@PostMapping
	public ResponseEntity<Response<EnderecoUsers>> cadastrar(@Valid @RequestBody EnderecoUsersDto dto){
		Response<EnderecoUsers> response = new Response<EnderecoUsers>();
		response.setData(this.enderecoUsersService.save(dto));
		return ResponseEntity.ok(response);
		 
		
	}
	
	
	@PutMapping
	public ResponseEntity<Response<EnderecoUsers>> update(@Valid @RequestBody EnderecoUsersDto dto)  {
		Response<EnderecoUsers> response = new Response<EnderecoUsers>();
		response.setData(this.enderecoUsersService.update(dto));
		return ResponseEntity.ok(response);
		
	}
	
	public ResponseEntity<Response<String>> removerEndereco(@PathVariable("id") Long id){
		Response<String> response = new Response<String>();
			this.enderecoUsersService.remove(id);
			response.setData("Endereço excluído com Sucesso");
			return ResponseEntity.ok(new Response<String>());
		
	}
	
	
}
