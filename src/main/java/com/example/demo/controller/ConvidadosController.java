package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Convidado;
import com.example.demo.repository.ConvidadoRepository;

@Controller
public class ConvidadosController {
	
	@Autowired
	ConvidadoRepository convidadoRepository;

	@GetMapping("/")
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidadoRepository.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
		
	}
	
	@PostMapping("/")
	public String salvar(Convidado convidado){
		this.convidadoRepository.save(convidado);
		return "redirect:/";
	}
	
	@GetMapping("/remove/{id}")
	public String remover(@PathVariable(name="id")Integer id,RedirectAttributes redirect) {
		
		redirect.addFlashAttribute("mensagem", "Convidado removido com sucesso");
		this.convidadoRepository.delete(new Long(id));
		return "redirect:/";
	}
	
}
