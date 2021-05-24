package br.edu.umj.filmes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.umj.filmes.model.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

		Optional<Filme> findById(Long id);
}
