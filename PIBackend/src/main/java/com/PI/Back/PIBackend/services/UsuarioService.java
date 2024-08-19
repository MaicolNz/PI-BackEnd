package com.PI.Back.PIBackend.services;


import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    UsuarioRepository usuarioRepository;

    public String listarUsuarios() {
        LOGGER.info("ACA ESTAMOS");
        return "Usuarios: bla bla";
    }
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
