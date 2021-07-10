package br.eti.scheffer.carsystem.clientes.mapper;


import br.eti.scheffer.carsystem.clientes.dtos.EnderecoClientesDto;
import br.eti.scheffer.core.entities.EnderecoClientes;
import com.fasterxml.jackson.databind.JsonNode;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoClientesMapper {
	
	
	public static EnderecoClientes toEntity(EnderecoClientes enderecoClientes, EnderecoClientesDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		if(!(enderecoClientes instanceof EnderecoClientes)) {
			enderecoClientes = new EnderecoClientes();
		}

		enderecoClientes.setId(dto.getId());
		enderecoClientes.setDescricao(dto.getDescricao());
		enderecoClientes.setComplemento(dto.getComplemento());
		enderecoClientes.setNumero(dto.getNumero());
		enderecoClientes.setUnidade(dto.getUnidade());
		enderecoClientes.setIbge(dto.getIbge());
		enderecoClientes.setGia(dto.getGia());
		enderecoClientes.setCep(dto.getCep());
		enderecoClientes.setLogradouro(dto.getLogradouro());
		enderecoClientes.setBairro(dto.getBairro());
		enderecoClientes.setLocalidade(dto.getLocalidade());
		enderecoClientes.setUf(dto.getUf());
		enderecoClientes.setSiafi(dto.getSiafi());

		return enderecoClientes;
	}
}
