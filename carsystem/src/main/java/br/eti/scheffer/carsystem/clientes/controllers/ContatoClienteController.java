package br.eti.scheffer.carsystem.clientes.controllers;


import br.eti.scheffer.carsystem.clientes.dtos.ContatoClienteDto;
import br.eti.scheffer.carsystem.clientes.services.ContatoClienteService;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.ContatoCliente;
import br.eti.scheffer.core.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contato")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ContatoClienteController {
	
	@Autowired
	private ContatoClienteService contatoClienteService;
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<ContatoCliente>> findById(@PathVariable("id") Long id){
		Response<ContatoCliente> response = new Response<ContatoCliente>();
		ContatoCliente contato = this.contatoClienteService.findByIdOrThrowBadRequestException(id);
		response.setData(contato);
		return ResponseEntity.ok(response);
	}
	
		
	@GetMapping(value = "/cliente/{id}")
	public ResponseEntity<List<ContatoCliente>> findContatosByClienteId(@PathVariable("id") Long id) {
		log.info("Consultando contatos por cliente {}", id);
		Clientes cliente = this.contatoClienteService.findClientesByIdOrThrowBadRequestException(id);
		List<ContatoCliente> contatos = cliente.getContato();
		return ResponseEntity.ok().body(contatos);
	}

	
    @PostMapping
	public ResponseEntity<Response<ContatoCliente>> salvar(@Valid @RequestBody ContatoClienteDto contatoClienteDto)  {
		Response<ContatoCliente> response = new Response<ContatoCliente>();
		response.setData(this.contatoClienteService.save(contatoClienteDto));
		return ResponseEntity.ok(response);
	}
 
 
 
	@PutMapping
	public ResponseEntity<Response<ContatoCliente>> update(@Valid @RequestBody ContatoClienteDto contatoClienteDto) {
		Response<ContatoCliente> response = new Response<ContatoCliente>();
		
		response.setData(this.contatoClienteService.update(contatoClienteDto));
		return ResponseEntity.badRequest().body(response);
		
		
	}

	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable("id") Long id) {
	
		Response<String> response = new Response<String>();
		this.contatoClienteService.remover(id);
		response.setData("Registro excluído com sucesso!");
		return ResponseEntity.ok(response);
		    
	}
	

}
