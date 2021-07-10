package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Roles implements Serializable  {


	private static final long serialVersionUID = 4450611031836781235L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "roles_seq")
	@SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "roles_name", nullable=false, length=25)
	private String rolesName;
	

	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();

	
}
