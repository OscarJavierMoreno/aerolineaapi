package com.generation.aerolineaapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClaseAsiento clase;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pasajero_id", nullable = false)
    private Pasajero pasajero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;

    // Constructor vacío obligatorio
    public Reserva() {}

    // Constructor con todos los campos excepto ID
    public Reserva(LocalDateTime fechaReserva, ClaseAsiento clase, Pasajero pasajero, Vuelo vuelo)
    {
        this.fechaReserva = fechaReserva;
        this.clase = clase;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
    public ClaseAsiento getClase() { return clase; }
    public void setClase(ClaseAsiento clase) { this.clase = clase; }
    public Pasajero getPasajero() { return pasajero; }
    public void setPasajero(Pasajero pasajero) { this.pasajero = pasajero; }
    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
}
