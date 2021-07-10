package br.eti.scheffer.carsystem.clientes.controllers;


import br.eti.scheffer.carsystem.clientes.dtos.EnderecoClientesDto;
import br.eti.scheffer.carsystem.clientes.services.EnderecoClientesService;
import br.eti.scheffer.core.entities.EnderecoClientes;
import br.eti.scheffer.core.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enderecocliente")
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoClienteController {
	
	private EnderecoClientesService enderecoClientesService;

	@GetMapping(value = "/cliente/{id}")
	public List<EnderecoClientes> listEnderecoClientes(@PathVariable("id") Long id) {
		return this.enderecoClientesService.listAll(id);
	}

	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<EnderecoClientes>> findEnderecoClienteById(@PathVariable("id") Long id){
		Response<EnderecoClientes> response = new Response<EnderecoClientes>();
		response.setData(this.enderecoClientesService.findByIdOrThrowNewBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
	

	@PostMapping
	public ResponseEntity<Response<EnderecoClientes>> cadastrar(@Valid @RequestBody EnderecoClientesDto dto){
		 Response<EnderecoClientes> response = new Response<EnderecoClientes>();
	     response.setData(this.enderecoClientesService.save(dto));
	     return ResponseEntity.ok(response);
	}
	

	@PutMapping 
	public ResponseEntity<Response<EnderecoClientes>> update(@Valid @RequestBody EnderecoClientesDto dto)  {
		Response<EnderecoClientes> response = new Response<EnderecoClientes>(); 
		response.setData(this.enderecoClientesService.update(dto));
		return ResponseEntity.ok(response);
		
	}

	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Response<String>> removerEndereco(@PathVariable("id") Long id){
		Response<String> response = new Response<String>();
		this.enderecoClientesService.remover(id);
		response.setData("Removido com sucesso!");
		return ResponseEntity.ok(response);
	}
	
	
}
