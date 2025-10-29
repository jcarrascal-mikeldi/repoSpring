package com.mikeldi.demo.sge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    // LISTAR TODOS LOS ROLES
    @GetMapping
    public String listarRoles(Model model) {
        List<Rol> roles = rolRepository.findAll();
        model.addAttribute("roles", roles);
        return "sge/roles-list"; // templates/sge/roles-list.html
    }

    // FORMULARIO NUEVO ROL
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Rol rolVacio = new Rol();
        model.addAttribute("rol", rolVacio);
        return "sge/rol-form"; // templates/sge/rol-form.html
    }

    // FORMULARIO EDITAR ROL EXISTENTE
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        model.addAttribute("rol", rol);
        return "sge/rol-form"; // misma vista que "nuevo"
    }

    // GUARDAR CAMBIOS (crear o editar)
    @PostMapping("/guardar")
    public String guardarRol(
            @RequestParam(required = false) Long id,
            @RequestParam String nombre,
            @RequestParam(required = false) String descripcion
    ) {
        Rol rol;

        if (id != null) {
            // Editar existente
            rol = rolRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        } else {
            // Crear nuevo
            rol = new Rol();
        }

        rol.setNombre(nombre);
        rol.setDescripcion(descripcion);

        rolRepository.save(rol);

        return "redirect:/roles";
    }

    // (OPCIONAL) ELIMINAR ROL
    @GetMapping("/borrar/{id}")
    public String borrarRol(@PathVariable Long id) {
        rolRepository.deleteById(id);
        return "redirect:/roles";
    }
}
