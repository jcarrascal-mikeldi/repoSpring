package com.mikeldi.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikeldi.demo.model.Persona;


public interface PersonaJpaRepository extends JpaRepository<Persona, Serializable> {


}
