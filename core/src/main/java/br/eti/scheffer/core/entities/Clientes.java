package br.eti.scheffer.core.entities;

import br.eti.scheffer.core.enums.TipoPessoa;
import br.eti.scheffer.core.enums.TipoSexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity()
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes", uniqueConstraints=
	@UniqueConstraint(columnNames={"cnpj_cpf"}))
public class Clientes implements Serializable {
	
	
	private static final long serialVersionUID = -2865257359015499597L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "clientes_seq")
	@SequenceGenerator(name = "clientes_seq", sequenceName = "clientes_seq", allocationSize = 1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	@Column(name = "razao_nome", nullable = false, length=255)
	private String razaoNome;

	@Column(name = "cnpj_cpf", nullable = true, length=14)
	private String cnpjCpf;
	
	@Column(name = "rg_ie", nullable = true, length=25)
	private String rgIe;
	
	@Column(name = "fantasia_apelido", nullable = false, length=255)
	private String fantasiaApelido;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "nascimento", nullable = true)
	private Date nascimento;
	
	@Enumerated(EnumType.STRING)
	private TipoSexo sexo;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="users", nullable=false)
	private Users users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<EnderecoClientes> enderecos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<ContatoCliente> contato;
	
	@Column(name = "ativo", nullable = false, columnDefinition = "boolean default false")
	private Boolean ativo = false;

	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();


}
