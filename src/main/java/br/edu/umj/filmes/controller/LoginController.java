package br.edu.umj.filmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("titulo", "Entrar");
		return "login/login";
	}
	
	@RequestMapping("/erro-login")
	public String erroLogin(Model model) {
		model.addAttribute("titulo", "Entrar");
		model.addAttribute("erro", true);
		return "login/login";
	}
}
