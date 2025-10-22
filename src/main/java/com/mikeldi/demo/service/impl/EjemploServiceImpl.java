package com.mikeldi.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mikeldi.demo.model.Persona;
import com.mikeldi.demo.service.EjemploService;

@Service("ejemploservicio")
public class EjemploServiceImpl implements EjemploService {
	
	@Override
	public List<Persona> getPersonas() {
		List<Persona> listapersonas= new ArrayList<Persona>();
		listapersonas.add(new Persona ("Maria","Gutierrez", "444Z", 10));
		listapersonas.add(new Persona ("Sonia","Lersundi", "555F", 25));
		listapersonas.add(new Persona ("Manolo", "García","666J", 50));
		listapersonas.add(new Persona ("Juan", "Sánchez", "777K", 14));
		return listapersonas;
	}

}
