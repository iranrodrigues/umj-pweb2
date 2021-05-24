package br.edu.umj.filmes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.umj.filmes.model.Ator;
import br.edu.umj.filmes.repository.AtorRepository;

@Controller
public class AtorController {

	@Autowired
	AtorRepository ar;
	
	@RequestMapping(value="/atores/novo", method=RequestMethod.GET)
	public String cadastrar(Model model) {
		Iterable<Ator> atores = ar.findAll();
		model.addAttribute("titulo", "Novo(a) ator/atriz");
		model.addAttribute("atores", atores);
		return "ator/novo";
	}
	
	@RequestMapping(value="/atores/novo", method=RequestMethod.POST)
	public String cadastrar(Ator a) {
		ar.save(a);
		return "redirect:/atores";
	}
	
	@RequestMapping(name="atorDetalhes", value="/atores/{id}")
	public String detalhes(@PathVariable("id") Long id, Model model) {
		Optional<Ator> ator = ar.findById(id);
		model.addAttribute("ator", ator.get());
		return "ator/detalhes";
	}
	
	@RequestMapping(name="atorEditar", value="/atores/editar/{id}",
			method=RequestMethod.GET)
	public String editar(@PathVariable("id") long id, Model model) {
		Optional<Ator> ator = ar.findById(id);
		model.addAttribute("ator", ator.get());
		Iterable<Ator> atores = ar.findAll();
		model.addAttribute("atores", atores);
		return "ator/editar";
	}
	
	@RequestMapping(value="/atores/editar/{id}",
			method=RequestMethod.POST)
	public String editar(@PathVariable("id") long id, Ator a) {
		ar.save(a);
		return "redirect:/atores";
	}
	
	@RequestMapping(name="atorExcluir", value="/atores/excluir/{id}",
			method=RequestMethod.GET)
	public String excluir(@PathVariable("id") long id, Model model) {
		Optional<Ator> ator = ar.findById(id);
		model.addAttribute("ator", ator.get());
		return "ator/excluir";
	}
	
	@RequestMapping(value="/atores/excluir/{id}",
			method=RequestMethod.POST)
	public String excluir(@PathVariable("id") long id) {
		ar.deleteById(id);
		return "redirect:/atores";
	}
	
	@RequestMapping("/atores")
	public String listar(Model model) {
		Iterable<Ator> atores = ar.findAll();
		model.addAttribute("titulo", "Todos(as) os(as) atores/atrizes");
		model.addAttribute("atores", atores);
		return "ator/lista";
	}
}
