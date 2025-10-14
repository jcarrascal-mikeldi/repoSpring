package com.mikeldi.demo.component;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mikeldi.demo.model.Persona;
import com.mikeldi.demo.model.Rol;
import com.mikeldi.demo.model.RolModulo;
import com.mikeldi.demo.model.Usuario;

@Component("ejemploComponent")
public class ComponentUsuarios {
	
	@Autowired 
	@Qualifier("listadoRoles") 
	ComponentRoles roles;
	
	public ArrayList <Usuario> getusuarios(){
		ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
		ArrayList<Rol> listaRoles = roles.getRoles();
		
		
		listaUsuarios.add(new Usuario ("Maria", "perez", "4743747"));
		RolModulo rolMaria1=new RolModulo(listaRoles.get(0), "ventas");
		RolModulo rolMaria2=new RolModulo(listaRoles.get(1), "compras");
		RolModulo rolMaria3=new RolModulo(listaRoles.get(0), "administracion");
		
		listaUsuarios.add(new Usuario ("Leire", "Gutierrez", "374847438"));
		RolModulo rolLeire1=new RolModulo(listaRoles.get(0), "ventas");
		RolModulo rolLeire2=new RolModulo(listaRoles.get(1), "compras");
				
		return listaUsuarios;
	}

}
