package br.eti.scheffer.carsystem.empresa.mapper;

import br.eti.scheffer.carsystem.empresa.dtos.EmpresaDto;
import br.eti.scheffer.core.entities.Empresa;

public class EmpresaMapper {

	public static Empresa toEntity(Empresa empresa, EmpresaDto empresaDto) {
		if(!(empresa instanceof Empresa)) {
			empresa = new Empresa();
		}
		empresa.setRazaoSocial(empresaDto.getRazaoSocial());
		empresa.setNomeFantasia(empresaDto.getNomeFantasia());
		empresa.setCnpj(empresaDto.getCnpj());
		empresa.setInscricaoEstadual(empresaDto.getInscricaoEstadual());
		empresa.setDataAbertura(empresaDto.getDataAbertura());
		empresa.setWebSite(empresaDto.getWebSite());
		
		return empresa;
	}
	

}
