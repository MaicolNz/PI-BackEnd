package com.PI.Back.PIBackend.services;


import com.PI.Back.PIBackend.entity.Role;
import com.PI.Back.PIBackend.entity.Usuario;
import com.PI.Back.PIBackend.exceptions.ResourceNotFoundException;
import com.PI.Back.PIBackend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioRepository usuarioRepository;



    @Transactional
    @Secured("ROLE_ADMIN")
    public void asignarRole(String email, Role newRole){
        //Obtener email
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        //Verificar administrador

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario currentUser = (Usuario) authentication.getPrincipal();

        if (!currentUser.getRole().equals(Role.ADMIN)){
            throw new SecurityException("Este usuario no tiene los permisos para asignar un nuevo rol");
        }

        //Asignar un nuevo rol
        usuario.setRole(newRole);
        usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }


}
