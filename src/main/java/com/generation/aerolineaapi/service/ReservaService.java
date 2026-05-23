package com.generation.aerolineaapi.service;

import com.generation.aerolineaapi.dto.ReservaRequestDTO;
import com.generation.aerolineaapi.dto.ReservaResponseDTO;
import com.generation.aerolineaapi.model.Pasajero;
import com.generation.aerolineaapi.model.Reserva;
import com.generation.aerolineaapi.model.Vuelo;
import com.generation.aerolineaapi.repository.PasajeroRepository;
import com.generation.aerolineaapi.repository.ReservaRepository;
import com.generation.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService
{
    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, PasajeroRepository pasajeroRepository, VueloRepository vueloRepository)
    {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    //Retorna una lista de DTO mapeados con stream y map
    public List<ReservaResponseDTO> findAll()
    {
        return reservaRepository.findAll().stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

    //Busca la reserva y si existe retorna su DTO, sino null
    public ReservaResponseDTO findById(Long id)
    {
        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null)
        {
            return null;
        }

        return ReservaResponseDTO.desde(reserva);
    }

    //Guarda la reserva buscando los objetos reales y retorna el DTO de salida
    public ReservaResponseDTO save(ReservaRequestDTO dto)
    {
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);

        if (pasajero == null || vuelo == null)
        {
            return null;
        }

        Reserva reserva = new Reserva(
                dto.getFechaReserva(),
                dto.getClase(),
                pasajero,
                vuelo
        );

        Reserva reservaGuardada = reservaRepository.save(reserva);
        return ReservaResponseDTO.desde(reservaGuardada);
    }

    //Actualiza una reserva existente y retorna su DTO, sino null
    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto)
    {
        Reserva reservaExistente = reservaRepository.findById(id).orElse(null);

        if (reservaExistente == null)
        {
            return null;
        }

        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);

        if (pasajero == null || vuelo == null)
        {
            return null;
        }

        reservaExistente.setFechaReserva(dto.getFechaReserva());
        reservaExistente.setClase(dto.getClase());
        reservaExistente.setPasajero(pasajero);
        reservaExistente.setVuelo(vuelo);

        Reserva reservaActualizada = reservaRepository.save(reservaExistente);
        return ReservaResponseDTO.desde(reservaActualizada);
    }

    public void delete(Long id)
    {
        reservaRepository.deleteById(id);
    }
}
