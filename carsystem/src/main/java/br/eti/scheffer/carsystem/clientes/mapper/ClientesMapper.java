package br.eti.scheffer.carsystem.clientes.mapper;


import br.eti.scheffer.carsystem.clientes.dtos.ClientesDto;
import br.eti.scheffer.core.entities.Clientes;
import br.eti.scheffer.core.entities.Users;
import br.eti.scheffer.core.enums.TipoPessoa;
import br.eti.scheffer.core.enums.TipoSexo;
import org.apache.commons.lang3.EnumUtils;


public class ClientesMapper {
	
	
	 public static Clientes toEntity(Clientes clientes, ClientesDto clientesDto) {
		 
	        if ( clientesDto == null ) {
	            return null;
	        }

	        if(!(clientes instanceof Clientes)) {
	        	clientes = new Clientes();
	        }

	        clientes.setId(clientesDto.getId());
	        clientes.setAtivo( clientesDto.getAtivo() );
	        clientes.setCnpjCpf( clientesDto.getCnpjCpf() );
	        clientes.setFantasiaApelido( clientesDto.getFantasiaApelido() );
	        clientes.setNascimento( clientesDto.getNascimento() );
	        clientes.setRazaoNome( clientesDto.getRazaoNome() );
	        clientes.setRgIe( clientesDto.getRgIe() );
	        if ( (clientesDto.getSexo() != null ) && (EnumUtils.isValidEnum(TipoSexo.class, clientesDto.getSexo()))) {
	            clientes.setSexo( Enum.valueOf( TipoSexo.class, clientesDto.getSexo() ) );
	        }
	        if ( (clientesDto.getTipoPessoa() != null) && (EnumUtils.isValidEnum(TipoPessoa.class, clientesDto.getTipoPessoa())) ) {
	            clientes.setTipoPessoa( Enum.valueOf( TipoPessoa.class, clientesDto.getTipoPessoa() ) );
	        }
	        Users users = new Users();
	        users.setId(clientesDto.getUsers());
	        clientes.setUsers(users);

	        return clientes;
	    }
	 
}
