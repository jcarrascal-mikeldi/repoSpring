package com.mikeldi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mikeldi")
public class HolaMundoController {
	
	@GetMapping("/holamundo")
	public String holaMundo() {
		return "holaMundo";
	}
	
}