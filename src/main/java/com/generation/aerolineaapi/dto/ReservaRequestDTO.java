package com.generation.aerolineaapi.dto;

import com.generation.aerolineaapi.model.ClaseAsiento;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservaRequestDTO
{
    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva;

    @NotNull(message = "La clase es obligatoria")
    private ClaseAsiento clase;

    @NotNull(message = "El ID del pasajero es obligatorio")
    private Long pasajeroId;

    @NotNull(message = "El ID del vuelo es obligatorio")
    private Long vueloId;

    public ReservaRequestDTO() {}

    // Getters y Setters
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
    public ClaseAsiento getClase() { return clase; }
    public void setClase(ClaseAsiento clase) { this.clase = clase; }
    public Long getPasajeroId() { return pasajeroId; }
    public void setPasajeroId(Long pasajeroId) { this.pasajeroId = pasajeroId; }
    public Long getVueloId() { return vueloId; }
    public void setVueloId(Long vueloId) { this.vueloId = vueloId; }
}
