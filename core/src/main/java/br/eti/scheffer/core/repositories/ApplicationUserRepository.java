package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.ApplicationUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long>{
	
	ApplicationUser findByUsername(String username);
	
	@Query("SELECT u FROM ApplicationUser u WHERE u.email = ?1")
    ApplicationUser findByemail(String username);
	
}
