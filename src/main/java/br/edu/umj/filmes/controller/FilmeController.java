package br.edu.umj.filmes.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.umj.filmes.model.Ator;
import br.edu.umj.filmes.model.Filme;
import br.edu.umj.filmes.repository.AtorRepository;
import br.edu.umj.filmes.repository.FilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	FilmeRepository fr;
	@Autowired
	AtorRepository ar;
	
	@RequestMapping(value="/filmes/novo", method=RequestMethod.GET)
	public String cadastrar(Model model) {
		Iterable<Filme> filmes = fr.findAll();
		model.addAttribute("filmes", filmes);
		return "filme/novo";
	}
	
	@RequestMapping(value="/filmes/novo", method=RequestMethod.POST)
	public String cadastrar(Filme f) {
		fr.save(f);
		return "redirect:/filmes";
	}
	
	@RequestMapping(name="detalhes", value="/filmes/{id}")
	public String detalhes(@PathVariable("id") Long id, Model model) {
		Optional<Filme> filme = fr.findById(id);
		model.addAttribute("filme", filme.get());
		return "filme/detalhes";
	}
	
	@RequestMapping(name="editar", value="/filmes/editar/{id}",
			method=RequestMethod.GET)
	public String editar(@PathVariable("id") long id, Model model) {
		Optional<Filme> filme = fr.findById(id);
		model.addAttribute("filme", filme.get());
		Iterable<Filme> filmes = fr.findAllByOrderByTituloAsc();
		model.addAttribute("filmes", filmes);
		Iterable<Ator> atores = ar.findAll();
		model.addAttribute("atores", atores);
		return "filme/editar";
	}
	
	@RequestMapping(value="/filmes/editar/{id}",
			method=RequestMethod.POST)
	public String editar(@PathVariable("id") long id, Filme f, @RequestParam("ator") int idAtor) {
		if (idAtor != -1) {
			Ator a = ar.findById((long) idAtor).get();
			if (f.getElenco() == null) {
				f.setElenco(new ArrayList<>());
			}
			f.getElenco().add(a);
			a.getFilmes().add(f);
			ar.save(a);
		}
		fr.save(f);
		return "redirect:/filmes";
	}
	
	@RequestMapping(name="excluir", value="/filmes/excluir/{id}",
			method=RequestMethod.GET)
	public String excluir(@PathVariable("id") long id, Model model) {
		Optional<Filme> filme = fr.findById(id);
		//if (filme.)
		model.addAttribute("filme", filme.get());
		return "filme/excluir";
	}
	
	@RequestMapping(value="/filmes/excluir/{id}",
			method=RequestMethod.POST)
	public String excluir(@PathVariable("id") long id) {
		fr.deleteById(id);
		return "redirect:/filmes";
	}
	
	@RequestMapping("/filmes")
	public String listar(Model model) {
		Iterable<Filme> filmes = fr.findAllByOrderByIdAsc();
		model.addAttribute("filmes", filmes);
		return "filme/lista";
	}
	
}
