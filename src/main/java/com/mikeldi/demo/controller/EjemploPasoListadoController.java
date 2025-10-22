package com.mikeldi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Persona;
import com.mikeldi.demo.service.impl.EjemploServiceImpl;

@Controller
@RequestMapping("/ejemplos")
public class EjemploPasoListadoController {
	final String plantillaPasoListado = "ejemplopasolistado";
	
	@Autowired
	@Qualifier("ejemploservicio")
	EjemploServiceImpl ejemploServicio;

	
	
	// OPCION 1 La mas corta
	@GetMapping("/ejemplo3")
	public String enviarListado(Model model) {
		model.addAttribute("personas", ejemploServicio.getPersonas());
		return plantillaPasoListado;
	}


	// OPCION 2 La mas larga
	@RequestMapping(value = "/ejemplo3mav", method = RequestMethod.GET)
	public ModelAndView enviarListadoMAV() {
		ModelAndView mav = new ModelAndView(plantillaPasoListado);
		mav.addObject("personas", ejemploServicio.getPersonas());
		return mav;
	}

	
}











