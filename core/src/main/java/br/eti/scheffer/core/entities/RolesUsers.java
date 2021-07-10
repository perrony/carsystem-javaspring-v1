package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles_users")
public class RolesUsers implements Serializable {
	
	
	private static final long serialVersionUID = -7747069536386952676L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rolesusers_seq")
	@SequenceGenerator(name = "rolesusers_seq", sequenceName = "rolesusers_seq", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "users", nullable = false)
	private Users users;
	
	@ManyToOne
	@JoinColumn(name = "roles", nullable = false)
	private Roles roles;
	
	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();
	


}
