package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUser implements Serializable {

	private static final long serialVersionUID = 2831447025282307076L;
	
	 public ApplicationUser() {
		  super();
	  }
	 
	public ApplicationUser(@NotNull ApplicationUser applicationUser) {
		  this.id =  applicationUser.getId(); 
		  this.username = applicationUser.getUsername();
		  this.password = applicationUser.getPassword(); 
		  this.rolesUsers = applicationUser.getRolesUsers();
    }
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	private Long id;
	
	@NotNull(message = "O campo 'email' é obrigatório")
	private String email; 
	
	private String username;
	
	@NotNull(message = "O campo 'password' é obrigatório")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private List<RolesUsers> rolesUsers;
	

}
