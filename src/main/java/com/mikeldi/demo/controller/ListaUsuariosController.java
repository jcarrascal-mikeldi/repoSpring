package com.mikeldi.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikeldi.demo.component.ComponentUsuarios;
import com.mikeldi.demo.model.Usuario;

public class ListaUsuariosController {
	
	@Autowired 
	@Qualifier("listadoUsuarios") 
	ComponentUsuarios compUsuarios;

	@GetMapping("/mostrarformulario")
	public String mostrarForm(Model model) {
		ArrayList<Usuario> listaUsuarios= compUsuarios.getusuarios();
		
		
		
		return "Pagina a la que quiera ir";
	}
}
