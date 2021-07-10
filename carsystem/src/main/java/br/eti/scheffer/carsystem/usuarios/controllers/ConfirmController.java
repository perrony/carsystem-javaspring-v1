package br.eti.scheffer.carsystem.usuarios.controllers;

import br.eti.scheffer.carsystem.usuarios.services.UsersService;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.exception.BadRequestException;
import br.eti.scheffer.core.mail.ConfirmHtml;
import br.eti.scheffer.core.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm")
@CrossOrigin(origins = "*")
public class ConfirmController {
	
	public ConfirmController() {}

	protected String text;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping(value = "/hash/{hash}")
	@ResponseBody
	public String findPage(@PathVariable("hash") String hash) {

		Users users = this.usersService.findByHashConfirmEquals(hash);
		
		if(!users.isConfirmed()) {
			users.setConfirmed(true);
			users.setAtivo(true);
			try {
				this.usersRepository.save(users);
				text = "Email confirmado, usuário ativo!";
			} catch (Exception e) {
				throw new BadRequestException("Email já confirmado, usuário ativo!");
			}
			
			
			
		}

		return ConfirmHtml.confirmHtml(text);

		
	}

}
