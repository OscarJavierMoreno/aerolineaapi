package com.generation.aerolineaapi.dto;

import com.generation.aerolineaapi.model.ClaseAsiento;
import com.generation.aerolineaapi.model.Reserva;
import java.time.LocalDateTime;

public class ReservaResponseDTO
{
    private Long id;
    private LocalDateTime fechaReserva;
    private ClaseAsiento clase;
    private Long pasajeroId;
    private String pasajeroNombre;
    private Long vueloId;
    private String vueloOrigen;
    private String vueloDestino;

    public ReservaResponseDTO() {}

    // Método estático solicitado desde(Reserva)
    public static ReservaResponseDTO desde(Reserva reserva)
    {
        ReservaResponseDTO dto = new ReservaResponseDTO();

        dto.setId(reserva.getId());
        dto.setFechaReserva(reserva.getFechaReserva());
        dto.setClase(reserva.getClase());
        dto.setPasajeroId(reserva.getPasajero().getId());
        dto.setPasajeroNombre(reserva.getPasajero().getNombre() + " " + reserva.getPasajero().getApellido());
        dto.setVueloId(reserva.getVuelo().getId());
        dto.setVueloOrigen(reserva.getVuelo().getOrigen());
        dto.setVueloDestino(reserva.getVuelo().getDestino());
        return dto;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
    public ClaseAsiento getClase() { return clase; }
    public void setClase(ClaseAsiento clase) { this.clase = clase; }
    public Long getPasajeroId() { return pasajeroId; }
    public void setPasajeroId(Long pasajeroId) { this.pasajeroId = pasajeroId; }
    public String getPasajeroNombre() { return pasajeroNombre; }
    public void setPasajeroNombre(String pasajeroNombre) { this.pasajeroNombre = pasajeroNombre; }
    public Long getVueloId() { return vueloId; }
    public void setVueloId(Long vueloId) { this.vueloId = vueloId; }
    public String getVueloOrigen() { return vueloOrigen; }
    public void setVueloOrigen(String vueloOrigen) { this.vueloOrigen = vueloOrigen; }
    public String getVueloDestino() { return vueloDestino; }
    public void setVueloDestino(String vueloDestino) { this.vueloDestino = vueloDestino; }
}
