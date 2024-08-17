package com.PI.Back.PIBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ALQUILERES")
@Getter @Setter
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "instrumento_id", nullable = false)
    private Instrumento instrumento;

    @ManyToOne
    @JoinColumn(name= "usuario_id", nullable = false)
    private Usuario usuario;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precioTotal;

    public Alquiler() {
    }

    public Alquiler(long id, Instrumento instrumento, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin, Double precioTotal) {
        this.id = id;
        this.instrumento = instrumento;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
    }
}
