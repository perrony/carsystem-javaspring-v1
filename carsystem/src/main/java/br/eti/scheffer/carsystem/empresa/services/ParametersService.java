package br.eti.scheffer.carsystem.empresa.services;

import br.eti.scheffer.carsystem.empresa.dtos.ParametersDto;
import br.eti.scheffer.core.entities.Parameters;

import java.util.Optional;

public interface ParametersService {

    Parameters loadParameters();

    Parameters save(ParametersDto dto);

    Parameters update(ParametersDto dto);

}
