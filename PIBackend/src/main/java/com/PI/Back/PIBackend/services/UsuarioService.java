package com.PI.Back.PIBackend.services;


import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        LOGGER.info("ACA ESTAMOS");
        return usuarioRepository.findAll();
    }
    public Usuario crearUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    public boolean verificarCredenciales(String correo, String contraseña) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(correo);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getContraseña().equals(contraseña); // No es recomendable almacenar contraseñas en texto plano
        }
        return false;
    }

}
