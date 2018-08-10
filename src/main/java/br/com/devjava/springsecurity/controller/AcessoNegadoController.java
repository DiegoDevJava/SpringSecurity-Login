package br.com.devjava.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AcessoNegadoController {

	@GetMapping("/acessonegado")
	public String acessoNegado() {
		return "acessonegado";
	}
}
