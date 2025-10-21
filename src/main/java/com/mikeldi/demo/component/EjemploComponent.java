package com.mikeldi.demo.component;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.mikeldi.demo.model.Persona;

@Component("ejemploComponent")
public class EjemploComponent {
	
	public ArrayList <Persona> getPersonas(){
		ArrayList<Persona> listaPersonas=new ArrayList<Persona>();
		listaPersonas.add(new Persona ("Maria", "perez", "4743747" , 10));
		listaPersonas.add(new Persona ("Leire", "Gutierrez", "374847438", 27));
		listaPersonas.add(new Persona ("Lorea", "Bazterra", "74873837Y" , 30));
		listaPersonas.add(new Persona ("Elena", "Dominguez", "333222333" , 35));
		listaPersonas.add(new Persona ("Ander", "Díez", "88837487", 25));
		return listaPersonas;
	}

	private static final Log LOG= LogFactory.getLog(EjemploComponent.class);
	
	public void saludito() {
		LOG.info("Mensaje desde el metodo saludito");
	}
	
}
