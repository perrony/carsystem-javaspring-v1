package br.eti.scheffer.carsystem.usuarios.controllers;

import br.eti.scheffer.carsystem.usuarios.dtos.RolesDto;
import br.eti.scheffer.carsystem.usuarios.services.RolesService;
import br.eti.scheffer.core.entities.Roles;
import br.eti.scheffer.core.response.Response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolesController {
	
	public RolesController() {}
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping
	public ResponseEntity<Page<Roles>> findRules(Pageable pageable){
		return ResponseEntity.ok(this.rolesService.listAllRoles(pageable));
	}

	@GetMapping(path = "/list")
	public ResponseEntity<List<Roles>> findAllRulesNotPageable(){
		return ResponseEntity.ok(this.rolesService.listAllRolesNotPageable());
	}
	
	
	@GetMapping(value = "/rolesname/{role}")
	public ResponseEntity<Response<Optional<Roles>>> findRuleName(@PathVariable("role") String role){
		Response<Optional<Roles>> response = new Response<Optional<Roles>>();
		response.setData(this.rolesService.findByRolesNameEquals(role));
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<Roles>> findRule(@PathVariable("id") Long id){
		Response<Roles> response = new Response<Roles>();
		response.setData(this.rolesService.findByIdOrElseThrowBadRequestException(id));
		return ResponseEntity.ok(response);
	}

	
	@PutMapping
	public ResponseEntity<Response<Roles>> update(@Valid @RequestBody RolesDto dto) {
		  Response<Roles> response = new Response<Roles>();
		  log.info(dto.toString());
		response.setData(this.rolesService.update(dto));
		return ResponseEntity.ok(response);
	}
	

	

	@PostMapping
	public ResponseEntity<Response<Roles>> cadastrar(@Valid @RequestBody RolesDto dto) {
		Response<Roles> response = new Response<Roles>();
		response.setData(this.rolesService.save(dto));
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> remover(@PathVariable("id") Long id) {
		Response<String> response = new Response<String>();
		this.rolesService.remove(id);
		response.setData("Excluído com Sucesso");
		return ResponseEntity.ok(response);
    
	
	}
	
}
