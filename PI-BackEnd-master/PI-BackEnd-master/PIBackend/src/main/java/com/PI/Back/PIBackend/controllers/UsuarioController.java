package com.PI.Back.PIBackend.controllers;

import com.PI.Back.PIBackend.entity.Role;
import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    final UsuarioService usuarioService;

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }


    @PutMapping("/changerole")
    @ResponseBody
    public void cambiarRol(@RequestParam("email") String email){
         usuarioService.asignarRole(email, Role.ADMIN);
    }





}
