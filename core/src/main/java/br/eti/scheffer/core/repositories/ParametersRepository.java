package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametersRepository extends JpaRepository<Parameters, Long> {

    Parameters findFirstByOrderByIdAsc();

}
