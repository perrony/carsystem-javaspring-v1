package br.eti.scheffer.core.entities;

import br.eti.scheffer.core.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity()
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contato_cliente")
public class ContatoCliente implements Serializable {
	
	private static final long serialVersionUID = 6236099684355066863L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "contato_cliente_seq")
	@SequenceGenerator(name = "contato_cliente_seq", sequenceName = "contato_cliente_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "descricao", nullable = false, length=45)
	private String descricao;
	
	@Column(name = "contato", nullable = false, length=255)
	private String contato;
	
	@Enumerated(EnumType.STRING)
	private TipoContato tipoContato;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cliente", nullable=false)
	private Clientes clientes;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "users", nullable = false)
	private Users users; 
	
	@JsonIgnore
	@Embedded
	private AbstractyEntityCreatedUpdated abstractyEntityCreatedUpdated = new AbstractyEntityCreatedUpdated();

}

	
	

	

