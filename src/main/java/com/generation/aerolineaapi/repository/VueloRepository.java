package com.generation.aerolineaapi.repository;

import com.generation.aerolineaapi.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>
{
}
