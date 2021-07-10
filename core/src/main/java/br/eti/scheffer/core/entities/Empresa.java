package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 8304272863114534645L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "empresa_seq")
	@SequenceGenerator(name = "empresa_seq", sequenceName = "empresa_seq", allocationSize = 1)
	private Long id;
	
	@Column(name="razao_social", nullable=false, length=255)
	private String razaoSocial;
	
	@Column(name="nome_fantasia", nullable=false, length=255)
	private String nomeFantasia;
	
	@Column(name="cnpj", nullable=false, length=14)
	private String cnpj;
	
	@Column(name="inscricao_estadual", nullable=false, length=20)
	private String inscricaoEstadual;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="data_abertura", nullable=true)
	private Date dataAbertura;
	
	@Column(name="web_site", nullable=true)
	private String webSite;
	
	@JsonIgnore
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Users> usuarios;
	
	@JsonIgnore
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<ContatoEmpresa> contato;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<EnderecoEmpresa> enderecos;
	
	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();
	

}
