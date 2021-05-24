package br.edu.umj.filmes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.umj.filmes.model.Ator;

public interface AtorRepository extends CrudRepository<Ator, Long> {

	Optional<Ator> findById(Long id);
}
