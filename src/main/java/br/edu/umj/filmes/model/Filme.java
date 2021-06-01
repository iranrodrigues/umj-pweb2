package br.edu.umj.filmes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="filme_seq")
	@SequenceGenerator(name = "filme_seq", sequenceName = "filme_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	@NotNull
	@Size(min = 1)
	private String titulo;
	@PositiveOrZero
	private int duracao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	private String direcao;
	private String sinopse;
	private double nota;
	@OneToOne
	private Filme sequencia;
	@OneToOne(mappedBy = "sequencia")
	private Filme anterior;
	@OneToMany(mappedBy = "filme")
	private List<Avaliacao> avaliacoes;
	@ManyToMany(mappedBy = "filmes")
	private List<Ator> elenco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDirecao() {
		return direcao;
	}
	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Filme getSequencia() {
		return sequencia;
	}
	public void setSequencia(Filme sequencia) {
		this.sequencia = sequencia;
	}
	public Filme getAnterior() {
		return anterior;
	}
	public void setAnterior(Filme anterior) {
		this.anterior = anterior;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public List<Ator> getElenco() {
		return elenco;
	}
	public void setElenco(List<Ator> elenco) {
		this.elenco = elenco;
	}
	
}
