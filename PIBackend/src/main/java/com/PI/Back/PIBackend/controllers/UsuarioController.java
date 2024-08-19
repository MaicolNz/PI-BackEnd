package com.PI.Back.PIBackend.controllers;


import com.PI.Back.PIBackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    @ResponseBody
    public String listarUsuarios(){
        return usuarioService.listarUsuarios();
    }
}
