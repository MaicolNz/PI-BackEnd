package com.PI.Back.PIBackend.services;

import com.PI.Back.PIBackend.entity.Instrumento;
import com.PI.Back.PIBackend.exceptions.ResourceNotFoundException;
import com.PI.Back.PIBackend.repository.InstrumentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentoService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    private InstrumentoRepository instrumentoRepository;

    @Transactional
    @Secured("ROLE_ADMIN")
    public boolean registrarInstrumento(Instrumento instrumento){
        try {
            instrumentoRepository.save(instrumento);
            return true;
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error durante el registro del instrumento", e.getMessage());
            return false; // Si hay error
        }
    }

    @Transactional
    @Secured("ROLE_ADMIN")
    public void borrarInstrumento(Long id) throws ResourceNotFoundException {
        if(id != null){
            instrumentoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el instrumento con id: {}", id);
        } else {
            throw new ResourceNotFoundException("No se ha encontrado el instrumento con el id: {}" + id);
        }
    }
}
