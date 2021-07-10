package br.eti.scheffer.core.repositories;


import br.eti.scheffer.core.entities.ContatoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContatoEmpresaRepository extends JpaRepository<ContatoEmpresa, Long> {

    ContatoEmpresa findByDescricaoContainingIgnoreCase(String descricao);

	ContatoEmpresa findByContatoContainingIgnoreCase(String contato);

}
