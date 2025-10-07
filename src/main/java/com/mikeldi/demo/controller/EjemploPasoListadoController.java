package com.mikeldi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mikeldi.demo.model.Persona;

@Controller
@RequestMapping("/ejemplos")
public class EjemploPasoListadoController {
	final String plantillaPasoListado = "ejemplopasolistado";

	// OPCION 1 La mas corta
	@GetMapping("/ejemplo3")
	public String enviarListado(Model model) {
		model.addAttribute("personas", getPersonas());
		return plantillaPasoListado;
	}


	// OPCION 2 La mas larga
	@RequestMapping(value = "/ejemplo3mav", method = RequestMethod.GET)
	public ModelAndView enviarListadoMAV() {
		ModelAndView mav = new ModelAndView(plantillaPasoListado);
		mav.addObject("personas", getPersonas());
		return mav;
	}

	
	
	private List <Persona> getPersonas(){
		List<Persona> listaPersonas=new ArrayList<Persona>();
		listaPersonas.add(new Persona ("Maria", "perez", "4743747" , 10));
		listaPersonas.add(new Persona ("Leire", "Gutierrez", "374847438", 27));
		listaPersonas.add(new Persona ("Lorea", "Bazterra", "74873837Y" , 30));
		listaPersonas.add(new Persona ("Elena", "Dominguez", "333222333" , 35));
		listaPersonas.add(new Persona ("Ander", "Díez", "88837487", 25));
		return listaPersonas;
	}
}











