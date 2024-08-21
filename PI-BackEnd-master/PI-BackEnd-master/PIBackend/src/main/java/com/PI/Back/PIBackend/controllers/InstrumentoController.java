package com.PI.Back.PIBackend.controllers;


import com.PI.Back.PIBackend.services.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstrumentoController {

    @Autowired
    InstrumentoService instrumentoService;
}
