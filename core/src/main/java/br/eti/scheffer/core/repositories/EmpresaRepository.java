package br.eti.scheffer.core.repositories;

import br.eti.scheffer.core.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findFirstByOrderByIdAsc();

    Optional<Empresa> findBycnpj(String cnpj);
}
