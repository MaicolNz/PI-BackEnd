package com.PI.Back.PIBackend.auth;

import com.PI.Back.PIBackend.controllers.UsuarioController;
import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("resgister")
    @ResponseBody
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
}
