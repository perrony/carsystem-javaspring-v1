package br.eti.scheffer.core.entities;

import br.eti.scheffer.core.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contato_empresa")
public class ContatoEmpresa implements Serializable {
	
	private static final long serialVersionUID = 774941493834502245L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "contato_empresa_seq")
	@SequenceGenerator(name = "contato_empresa_seq", sequenceName = "contato_empresa_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "descricao", nullable = false, length=45)
	private String descricao;
	
	@Column(name = "contato", nullable = false, length=255)
	private String contato;
	
	@Enumerated(EnumType.STRING)
	private TipoContato tipoContato;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa", nullable = false)
	private Empresa empresa;

	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();


}
