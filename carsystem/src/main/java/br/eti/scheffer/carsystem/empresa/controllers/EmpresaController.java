package br.eti.scheffer.carsystem.empresa.controllers;

import br.eti.scheffer.carsystem.empresa.dtos.EmpresaDto;
import br.eti.scheffer.carsystem.empresa.services.EmpresaService;
import br.eti.scheffer.core.entities.Empresa;
import br.eti.scheffer.core.response.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	public EmpresaController() {
	}

	@GetMapping
	public ResponseEntity<Response<Empresa>> loadEmpresa(){
		Response<Empresa> response = new Response<Empresa>();
		response.setData(this.empresaService.findFirstByOrderByIdAsc());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<Empresa>> findEmpresa(@PathVariable("id") Long id){
		Response<Empresa> response = new Response<Empresa>();
		response.setData(this.empresaService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
	

	@GetMapping(value = "/cnpj/{cnpj}")
	public ResponseEntity<Response<Empresa>> findByCnpj(@PathVariable("cnpj") String cnpj){
		Response<Empresa> response = new Response<Empresa>();
		response.setData(this.empresaService.findBycnpj(cnpj));
		return ResponseEntity.ok(response);
	}
	

	@PostMapping
	public ResponseEntity<Response<Empresa>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto) {
		Response<Empresa> response = new Response<Empresa>();
		response.setData(this.empresaService.save(empresaDto));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<Empresa>> update(@Valid @RequestBody EmpresaDto empresaDto) {
		Response<Empresa> response = new Response<Empresa>();
		this.empresaService.update(empresaDto);
		response.setData(this.empresaService.update(empresaDto));
		return ResponseEntity.ok(response);
		
	}
}
