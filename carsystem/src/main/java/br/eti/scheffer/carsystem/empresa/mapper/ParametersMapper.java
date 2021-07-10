package br.eti.scheffer.carsystem.empresa.mapper;

import br.eti.scheffer.carsystem.empresa.dtos.ParametersDto;
import br.eti.scheffer.core.entities.Parameters;
import br.eti.scheffer.core.utils.PasswordUtils;

public class ParametersMapper {


    public static Parameters toEntity(Parameters parameters, ParametersDto dto) {

        if(!(parameters instanceof Parameters)) {
             parameters = new Parameters();
        }
            parameters.setSmtp(dto.getSmtp());
            parameters.setPort(dto.getPort());
            parameters.setAddressFrom(dto.getAddressFrom());
            parameters.setUsername(dto.getUsername());
            parameters.setPassword(PasswordUtils.encode64(dto.getPassword()));
        return parameters;
    }

}





