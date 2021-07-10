package br.eti.scheffer.core.entities;

import br.eti.scheffer.core.utils.Hash;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users implements Serializable {


	private static final long serialVersionUID = -4420824771873124739L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "username", nullable=false, length=255)
	private String username;
	
	@Column(name = "nome", nullable=false, length=50)
	private String nome;
	
	@Column(name = "sobrenome", nullable=false, length=100)
	private String sobrenome;
	
	@Column(name = "cpf", nullable=false)
	private String cpf;
	

	@Column(name = "email", nullable=false, length=255)
	private String email;
	
	@Column(name = "confirmed", nullable=false)
	private boolean confirmed;
	
	@Column(name = "ativo", nullable=false)
	private boolean ativo;
	
	@Getter(onMethod = @__( @JsonIgnore ))
	@Column(name = "hash_confirm", nullable=false, length=255)
	private String hashConfirm;
	
	@Getter(onMethod = @__( @JsonIgnore ))
	@Column(name = "password", nullable=false, length=255)
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<RolesUsers> rolesUsers;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	private List<Users> users;

	@OneToMany(mappedBy = "users")
	private List<EnderecoUsers> enderecos;

	
	@PreUpdate
	public void preUpdate() {
		hashConfirm = Hash.getSHA512(new Date().toString()+nome);
		this.setUsername(this.email);
	}
	
	@PrePersist
	public void prePersist() {
		hashConfirm = Hash.getSHA512(new Date().toString()+nome);
		this.setUsername(this.email);

	}
	
	
	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();

	
}
