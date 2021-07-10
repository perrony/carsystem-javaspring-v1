package br.eti.scheffer.auth.security.users;

import br.eti.scheffer.core.entities.ApplicationUser;
import br.eti.scheffer.core.repositories.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	

	@Autowired
	private ApplicationUserRepository  applicationUserRepository;


	
	@Override
	public UserDetails loadUserByUsername(String username)  {

		/*
		 * log.info("Searching in the DB the user by username '{}'", username);
		 * ApplicationUser applicationUser =
		 * applicationUserRepository.findByUsername(username);
		 */

		log.info("Buscando no DB usuário pelo email '{}'", username);
		ApplicationUser applicationUser = applicationUserRepository.findByemail(username);
		
		if(applicationUser == null) {
			throw new UsernameNotFoundException(String.format("Application user '%s'", username));
		}
		
		log.info("Usuário encontrado '{}'", applicationUser.toString());


		return new CustomUserDetails(applicationUser);

	}
	
	private static final class CustomUserDetails extends ApplicationUser implements UserDetails {
		
		private static final long serialVersionUID = 1L;

		CustomUserDetails(@NotNull ApplicationUser applicationUser) {
			super(applicationUser);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {

			List<String> lista = new ArrayList<>();

			this.getRolesUsers().forEach(n -> lista.add(n.getRoles().getRolesName()));

			return AuthorityUtils.commaSeparatedStringToAuthorityList(lista.toString());

		}
		
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
		
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}
		
		@Override
		public boolean isEnabled() {
			return true;
		}
		
		
		
	}

}
