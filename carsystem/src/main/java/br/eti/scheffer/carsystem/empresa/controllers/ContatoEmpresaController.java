package br.eti.scheffer.carsystem.empresa.controllers;

import br.eti.scheffer.carsystem.empresa.dtos.ContatoEmpresaDto;
import br.eti.scheffer.carsystem.empresa.services.ContatoEmpresaService;
import br.eti.scheffer.core.entities.ContatoEmpresa;
import br.eti.scheffer.core.response.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contatoempresa")
@CrossOrigin(origins = "*")
public class ContatoEmpresaController {
	
	@Autowired
	public ContatoEmpresaService contatoEmpresaService;

	@GetMapping(value="/empresa/{id}")
	public ResponseEntity<List<ContatoEmpresa>> findContatosByEmpresa(@PathVariable("id") Long id) {
		System.out.println("Consultando contatos");
		return ResponseEntity.ok(this.contatoEmpresaService.listContatos(id));
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<ContatoEmpresa>> findById(@PathVariable("id") Long id){
		Response<ContatoEmpresa> response = new Response<ContatoEmpresa>();
		response.setData(this.contatoEmpresaService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/contato/{contato}")
	public ResponseEntity<Response<ContatoEmpresa>> findByContato(@PathVariable("contato") String contato){
		Response<ContatoEmpresa> response = new Response<ContatoEmpresa>();
		response.setData(this.contatoEmpresaService.findByContatoContainingIgnoreCase(contato));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/descricao/{descricao}")
	public ResponseEntity<Response<ContatoEmpresa>> findByDescricao(@PathVariable("descricao") String descricao){
		Response<ContatoEmpresa> response = new Response<ContatoEmpresa>();
		response.setData(this.contatoEmpresaService.findByDescricaoContainingIgnoreCase(descricao));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<ContatoEmpresa>> cadastrar(@Valid @RequestBody ContatoEmpresaDto contatoEmpresaDto){
		Response<ContatoEmpresa> response = new Response<ContatoEmpresa>();
		response.setData(this.contatoEmpresaService.save(contatoEmpresaDto));
		return ResponseEntity.ok(response);
	
		
	}
 
 
	@PutMapping
	public ResponseEntity<Response<ContatoEmpresa>> update(@Valid @RequestBody ContatoEmpresaDto dto){
			Response<ContatoEmpresa> response = new Response<ContatoEmpresa>();
			response.setData(this.contatoEmpresaService.update(dto));
			return ResponseEntity.ok(response);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable("id") Long id) {
		Response<String> response = new Response<String>();
		this.contatoEmpresaService.remover(id);
		response.setData("Contato excluído com sucesso!");
		return ResponseEntity.ok().body(response);
	}
	

}
