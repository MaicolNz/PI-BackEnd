package com.PI.Back.PIBackend.auth;

import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.jwt.JwtService;
import com.PI.Back.PIBackend.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))  // Encriptar la contraseña
                .build();

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        return new AuthResponse();
    }
}
