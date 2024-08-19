package com.PI.Back.PIBackend.services;


import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public String listarUsuarios() {
        return "Usuarios: bla bla";
    }
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
