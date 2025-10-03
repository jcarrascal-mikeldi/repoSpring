package com.mikeldi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Persona;


@Controller
@RequestMapping("/ejemplos")
public class EjemploPasoObjetoController {
	final String plantillaPasoObjeto="plantillapasoobjeto";
	
	@GetMapping("/ejemplo2")
	public String pasoObjeto(Model model) {
		Persona p1= new Persona();
		p1.setEdad(20);
		p1.setNombre("María");
		model.addAttribute("persona", p1);
		return plantillaPasoObjeto;
	}
	
	@RequestMapping(value="/ejemplo2mav", method=RequestMethod.GET)
	public ModelAndView pasoObjetoMAV() {
		Persona p1= new Persona();
		p1.setEdad(50);
		p1.setNombre("Antonia");
		ModelAndView mav = new ModelAndView(plantillaPasoObjeto);
		mav.addObject("persona", p1);
		return mav;
		
	}



}
