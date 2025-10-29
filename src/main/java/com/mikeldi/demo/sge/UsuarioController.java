package com.mikeldi.demo.sge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <- esto es importante, no RestController
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // LISTAR TODOS LOS USUARIOS
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "sge/usuarios-list"; // templates/usuarios-list.html
    }

    // FORMULARIO: NUEVO USUARIO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Usuario usuarioVacio = new Usuario();
        model.addAttribute("usuario", usuarioVacio);

        List<Rol> todosLosRoles = rolRepository.findAll();
        model.addAttribute("rolesDisponibles", todosLosRoles);

        return "sge/usuario-form"; // templates/usuario-form.html
    }

    // FORMULARIO: EDITAR USUARIO EXISTENTE
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        model.addAttribute("usuario", usuario);

        List<Rol> todosLosRoles = rolRepository.findAll();
        model.addAttribute("rolesDisponibles", todosLosRoles);

        return "sge/usuario-form"; // usamos misma vista
    }

    // GUARDAR (tanto crear como editar)
    @PostMapping("/guardar")
    public String guardarUsuario(
            @RequestParam(required=false) Long id,
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam(required=false) String passwordPlano,
            @RequestParam(defaultValue="false") boolean activo,
            @RequestParam(required=false, name="rolesSeleccionados") List<Long> rolesSeleccionadosIds
    ) {

        Usuario u;
        if (id != null) {
            // editar existente
            u = usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        } else {
            // nuevo
            u = new Usuario();
            u.setEmail(email);

            if (usuarioRepository.existsByEmail(email)) {
                throw new RuntimeException("Ya existe un usuario con ese email");
            }
        }

        u.setNombre(nombre);
        u.setActivo(activo);

        // si en el form ha metido password nueva, la cambiamos
        if (passwordPlano != null && !passwordPlano.isBlank()) {
            u.setPasswordHash(passwordEncoder.encode(passwordPlano));
        }

        // roles marcados en el formulario (checkboxes)
        if (rolesSeleccionadosIds != null && !rolesSeleccionadosIds.isEmpty()) {
            Set<Rol> nuevosRoles = new HashSet<>(rolRepository.findAllById(rolesSeleccionadosIds));
            u.setRoles(nuevosRoles);
        } else {
            // si no marca nada, dejamos vacío
            u.setRoles(new HashSet<>());
        }

        usuarioRepository.save(u);

        // después de guardar volvemos a la lista
        return "redirect:/usuarios";
    }
}
