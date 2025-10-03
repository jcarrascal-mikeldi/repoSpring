package com.mikeldi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ejemplos")
public class EjemploPasoValorController {
	//Utilizamos una constante para cosas que no vayan a modificarse a menudo
	final String plantillaPasoValor="ejemplopasovalor";
	
	//Modo 1 para pasar un valor de un controller a una plantilla
	@GetMapping("/ejemplo1")
	public String funcion1(Model model) {
		//El model sirve para guardar y recuperar datos de la navegación
		model.addAttribute("persona", "pepe");
		//Devuelvo la vista a la que quiero acceder, que será ejemplopasovalor.html
		return plantillaPasoValor;
	}
	
	//Modo 2
	@RequestMapping(value="/ejemplo1mav", method=RequestMethod.GET)
	public ModelAndView funcion2() {
		ModelAndView mav = new ModelAndView(plantillaPasoValor);
		mav.addObject("persona", "Juan");
		return mav;
	}
	
	
	
}
