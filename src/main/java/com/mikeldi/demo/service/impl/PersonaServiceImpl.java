package com.mikeldi.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mikeldi.demo.model.Persona;
import com.mikeldi.demo.repository.PersonaJpaRepository;
import com.mikeldi.demo.service.PersonaService;



@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	@Qualifier("personaJpaRepository")
	private PersonaJpaRepository personaJpaRepository;

	@Override
	public Persona aniadirPersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaJpaRepository.save(persona);
	}



}
