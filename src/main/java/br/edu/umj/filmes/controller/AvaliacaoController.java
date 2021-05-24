package br.edu.umj.filmes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.umj.filmes.model.Avaliacao;
import br.edu.umj.filmes.repository.AvaliacaoRepository;

@Controller
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoRepository ar;
	
	@RequestMapping(value="/filmes/{id}/avaliar", method=RequestMethod.POST)
	public String cadastrar(@PathVariable("id") long id, Avaliacao a) {
		a.setTimestamp(new Date());
		ar.save(a);
		return "redirect:/filmes/" + id;
	}
	
}
