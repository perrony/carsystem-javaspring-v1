package br.eti.scheffer.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco_users")
public class EnderecoUsers implements Serializable{

	private static final long serialVersionUID = 7126786069414915360L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "users_enderecos_seq")
	@SequenceGenerator(name = "users_enderecos_seq", sequenceName = "users_enderecos_seq", allocationSize = 1)
	private Long id;

	@Column(name = "descricao", nullable = false, length=150)
	private String descricao;

	@Column(name="complemento", nullable=true, length=200)
	private String complemento;

	@Column(name="numero", nullable=true, length=10)
	private String numero;

	@Column(name = "unidade", nullable = true, length=150)
	private String unidade;

	@Column(name = "ibge", nullable = true, length=7)
	private String ibge;

	@Column(name = "gia", nullable = true, length=150)
	private String gia;

	@Column(name="cep", nullable=true, length=10)
	private String cep;

	@Column(name="logradouro", nullable=false, length=200)
	private String logradouro;

	@Column(name="bairro", nullable=false, length=150)
	private String bairro;

	@Column(name="cidade", nullable=false, length=150)
	private String localidade;

	@Column(name="uf", nullable=false, length=2)
	private String uf;

	@Column(name="siafi", nullable=false, length=10)
	private String siafi;

	@ManyToOne(fetch = FetchType.EAGER)
	private Users users;

	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();
	

}
