package br.edu.umj.filmes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="avaliacao_seq")
	@SequenceGenerator(name = "avaliacao_seq", sequenceName = "avaliacao_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	private int nota;
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	private Date timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
