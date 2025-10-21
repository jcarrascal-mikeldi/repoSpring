package com.mikeldi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikeldi.demo.component.EjemploComponent;



@Controller
@RequestMapping("/ejemplos")
public class EjemploComponentAndLogController {
	
	final String plantillaPasoValor = "ejemplopasolistado";
	
	@Autowired
	@Qualifier("ejemploComponent")
	EjemploComponent ejemplo;

	
	@GetMapping("/ejemploconfig")
	public String helloWorld(Model model) {

		ejemplo.saludito();
		return plantillaPasoValor;
	}
	
	

}
