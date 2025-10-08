package com.mikeldi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Persona;

@Controller
@RequestMapping("/ejemplos")
public class EjemploFormularioListadoController {
	final String plantillaFormularioListado = "formulariolistado";
	private ArrayList<Persona> personas= new ArrayList<Persona>();

	@GetMapping("/mostrarformulario")
	public String mostrarForm(Model model) {
		model.addAttribute("persona", new Persona());
		personas.add(new Persona("Pedro", "Perez", "0", 22));
		model.addAttribute("personas", personas);
		return plantillaFormularioListado;
	}
	
	@PostMapping("/aniadirpersona")
	public ModelAndView aniadirPersona(@ModelAttribute("persona") Persona persona) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(plantillaFormularioListado);
		personas.add(persona);
		mav.addObject("personas", personas);
		return mav;
	}
	
	
	
}











