package com.mikeldi.demo.model;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String DNI;
	private ArrayList<RolModulo> roles = new ArrayList<RolModulo>();

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidos, String dNI) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<RolModulo> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<RolModulo> roles) {
		this.roles = roles;
	}
	
	public void aniadidRol(RolModulo rol) {
		this.getRoles().add(rol);
	}
	
	
	

}
