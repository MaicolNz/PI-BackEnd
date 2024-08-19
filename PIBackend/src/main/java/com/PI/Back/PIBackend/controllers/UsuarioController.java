package com.PI.Back.PIBackend.controllers;


import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/usuarios")
    @ResponseBody
    public String listarUsuarios(){
        LOGGER.info("ACA ESTAMOS");
        return usuarioService.listarUsuarios();
    }
    @PostMapping("/usuarios")
    @ResponseBody
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }
}
