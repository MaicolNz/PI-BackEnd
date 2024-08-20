package com.PI.Back.PIBackend.dto.salida;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioSalidaDto {

    private long id;

    private String nombre;

    private String apellido;

    private String email;
    private String direccion;
    private String celular;

    public UsuarioSalidaDto() {
    }

    public UsuarioSalidaDto(long id, String nombre, String apellido, String email, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.celular = celular;
    }
}
