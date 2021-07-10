package br.eti.scheffer.carsystem.clientes.controllers;



import br.eti.scheffer.carsystem.clientes.dtos.ClientesDto;
import br.eti.scheffer.carsystem.clientes.services.ClientesService;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.repositories.ClientesRepository;
import br.eti.scheffer.core.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ClientesController {
	

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private ClientesService clientesService;
		
	/**
	 * Retorna um array de objetos de clientes
	 * 
	 * @return
	 */
	@GetMapping()
	public Page<Clientes> listClientes(Pageable pageable) {
		log.info("Listando clientes");
		 Page<Clientes> clientes = this.clientesRepository.findAll(pageable);
		 return clientes;
	}
	
	/**
	 * Retorna um objeto de um cliente
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<Clientes>> findClienteById(@PathVariable("id") Long id){
		log.info("Consultado cliente por ID {}", id);
		Response<Clientes> response = new Response<Clientes>();
		response.setData(this.clientesService.findByIdOrThrowBadRequestException(id));
		return ResponseEntity.ok(response);
		
	}
	
	
	
	/**
	 * Persiste um objeto cliente na base de dados
	 * 
	 * @param clientesDto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response<Clientes>> cadastrar(@Valid @RequestBody ClientesDto clientesDto){
		log.info("Cadastrando Cliente {}", clientesDto.toString());
		Response<Clientes> response = new Response<Clientes>();
		response.setData(this.clientesService.save(clientesDto));  
		return ResponseEntity.ok(response);
		 
		
	}
	

	/**
	 * Update objeto Cliente na base de dados
	 * 
	 * @param clientesDto
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Response<Clientes>> update(@Valid @RequestBody ClientesDto clientesDto)  {
		Response<Clientes> response = new Response<Clientes>();
		response.setData(this.clientesService.update(clientesDto));
		return ResponseEntity.ok(response);
		
	}
	

	
}
