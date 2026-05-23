package com.generation.aerolineaapi.service;

import com.generation.aerolineaapi.model.Pasajero;
import com.generation.aerolineaapi.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasajeroService
{
    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository)
    {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll()
    {
        return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero)
    {
        return pasajeroRepository.save(pasajero);
    }

    public Pasajero findById(Long id)
    {
        return pasajeroRepository.findById(id).orElse(null);
    }

    public Pasajero update(Long id, Pasajero datos)
    {
        Pasajero pasajeroExistente = findById(id);
        if (pasajeroExistente == null)
        {
            return null;
        }

        pasajeroExistente.setNombre(datos.getNombre());
        pasajeroExistente.setApellido(datos.getApellido());
        pasajeroExistente.setDocumento(datos.getDocumento());
        pasajeroExistente.setEmail(datos.getEmail());
        return pasajeroRepository.save(pasajeroExistente);
    }

    public void delete(Long id)
    {
        pasajeroRepository.deleteById(id);
    }
}
