package com.generation.aerolineaapi.repository;

import com.generation.aerolineaapi.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long>
{
}