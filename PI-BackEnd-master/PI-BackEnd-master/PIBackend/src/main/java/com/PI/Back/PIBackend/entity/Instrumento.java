package com.PI.Back.PIBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INSTRUMENTOS")
@Getter @Setter
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String tipo;
    private String proovedor;
    private Double precioDriario;
    private int stock;
    private String imagen;
    private String detalle;

    public Instrumento() {
    }

    public Instrumento(long id, String nombre, String tipo, String proovedor, Double precioDriario, int stock, String imagen, String detalle) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.proovedor = proovedor;
        this.precioDriario = precioDriario;
        this.stock = stock;
        this.imagen = imagen;
        this.detalle = detalle;
    }
}
