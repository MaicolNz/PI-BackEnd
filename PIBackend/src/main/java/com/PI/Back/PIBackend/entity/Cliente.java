package com.PI.Back.PIBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENTES")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String celular;

    public Cliente(Long id, String direccion, String celular) {
        this.id = id;
        this.direccion = direccion;
        this.celular = celular;
    }

    public Cliente() {

    }

}


