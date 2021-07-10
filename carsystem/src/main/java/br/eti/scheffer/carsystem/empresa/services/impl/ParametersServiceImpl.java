package br.eti.scheffer.carsystem.empresa.services.impl;

import br.eti.scheffer.carsystem.empresa.dtos.ParametersDto;
import br.eti.scheffer.carsystem.empresa.mapper.ParametersMapper;
import br.eti.scheffer.carsystem.empresa.services.ParametersService;
import br.eti.scheffer.core.entities.Parameters;
import br.eti.scheffer.core.repositories.ParametersRepository;
import br.eti.scheffer.core.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ParametersServiceImpl implements ParametersService {

    @Autowired
    private ParametersRepository parametersRepository;

    public Parameters loadParameters(){
        Parameters parameters = this.parametersRepository.findFirstByOrderByIdAsc();
        String passwordDecode = PasswordUtils.decode64(parameters.getPassword());
        parameters.setPassword(passwordDecode);
        return parameters;
    }

    @Override
    public Parameters save(ParametersDto dto) {
        return this.parametersRepository.save(ParametersMapper.toEntity(null,dto));
    }

    @Override
    public Parameters update(ParametersDto dto) {
        Parameters parametersSalved = this.parametersRepository.findFirstByOrderByIdAsc();
        return this.parametersRepository.save(ParametersMapper.toEntity(parametersSalved, dto));
    }


}
