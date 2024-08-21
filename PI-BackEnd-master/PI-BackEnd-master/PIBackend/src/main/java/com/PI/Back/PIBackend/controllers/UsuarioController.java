package com.PI.Back.PIBackend.controllers;

import com.PI.Back.PIBackend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    final UsuarioService usuarioService;
}
