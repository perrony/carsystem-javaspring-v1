package br.eti.scheffer.carsystem.empresa.controllers;

import br.eti.scheffer.carsystem.empresa.dtos.EnderecoEmpresaDto;
import br.eti.scheffer.carsystem.empresa.services.EnderecoEmpresaService;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.entities.EnderecoEmpresa;
import br.eti.scheffer.core.response.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enderecoempresa")
public class EnderecoEmpresaController {
	
	@Autowired
	private EnderecoEmpresaService enderecoEmpresaService;
	
	@GetMapping(value = "/empresa/{id}")
	public List<EnderecoEmpresa> listEnderecoEmpresa(@PathVariable("id") Long id) {
		Empresa empresa = this.enderecoEmpresaService.findEmpresaByIdOrElseThrowBadRequestException(id);
		return empresa.getEnderecos();
	}


	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<EnderecoEmpresa>> findEnderecoEmpresaById(@PathVariable("id") Long id){
		Response<EnderecoEmpresa> response = new Response<EnderecoEmpresa>();
		response.setData(this.enderecoEmpresaService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
	
	
	@PostMapping
	public ResponseEntity<Response<EnderecoEmpresa>> cadastrar(@Valid @RequestBody EnderecoEmpresaDto dto){
		Response<EnderecoEmpresa> response = new Response<EnderecoEmpresa>();
		response.setData(this.enderecoEmpresaService.save(dto));  
		return ResponseEntity.ok(response);
	}
	
	
	
	@PutMapping
	public ResponseEntity<Response<EnderecoEmpresa>> update(@Valid @RequestBody EnderecoEmpresaDto dto)  {
		Response<EnderecoEmpresa> response = new Response<EnderecoEmpresa>();
		response.setData(this.enderecoEmpresaService.update(dto));
		return ResponseEntity.ok(response);
		
	}
	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Response<String>> removerEndereco(@PathVariable("id") Long id){
		Response<String> response = new Response<String>();
		this.enderecoEmpresaService.remover(id);
		response.setData("Endereço excluído com sucesso!");
		return ResponseEntity.ok(response);
		
		
	}
	
	
}
