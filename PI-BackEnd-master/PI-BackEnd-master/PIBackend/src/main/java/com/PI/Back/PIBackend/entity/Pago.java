package com.PI.Back.PIBackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Alquiler alquiler;

    private Double monto;
    private LocalDate fechaDePago;
    private String metodoDePago;

    public Pago() {
    }

    public Pago(long id, Alquiler alquiler, Double monto, LocalDate fechaDePago, String metodoDePago) {
        this.id = id;
        this.alquiler = alquiler;
        this.monto = monto;
        this.fechaDePago = fechaDePago;
        this.metodoDePago = metodoDePago;
    }
}
