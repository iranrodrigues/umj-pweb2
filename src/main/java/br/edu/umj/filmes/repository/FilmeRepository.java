package br.edu.umj.filmes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.umj.filmes.model.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

		Optional<Filme> findById(Long id);
		List<Filme> findAllByOrderByIdAsc();
		List<Filme> findAllByOrderByTituloAsc();
		
		@Query("SELECT COALESCE(avg(a.nota), 0) FROM Avaliacao a WHERE (a.filme.id = ?1)")
		public Double mediaAvaliacoes(Long id);
}
