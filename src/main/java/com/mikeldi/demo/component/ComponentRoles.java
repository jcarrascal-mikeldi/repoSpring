package com.mikeldi.demo.component;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.mikeldi.demo.model.Persona;
import com.mikeldi.demo.model.Rol;
import com.mikeldi.demo.model.Usuario;

@Component("listadoRoles")
public class ComponentRoles {
	
	public ArrayList <Rol> getRoles(){
		ArrayList<Rol> listaRoles=new ArrayList<Rol>();
		listaRoles.add(new Rol(1, "Administrador", "Descripcion de administrador"));
		listaRoles.add(new Rol(2, "Directivo", "Descripcion de directivo"));
		listaRoles.add(new Rol(3, "Empleado", "Descripcion de empleado"));
		listaRoles.add(new Rol(4, "Supervisor", "Descripcion de supervisor"));
		return listaRoles;
	}

}
