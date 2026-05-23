package com.generation.aerolineaapi.controller;

import com.generation.aerolineaapi.dto.ReservaRequestDTO;
import com.generation.aerolineaapi.dto.ReservaResponseDTO;
import com.generation.aerolineaapi.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reservas", description = "Gestión de las reservas de vuelos")
@RestController
@RequestMapping("/reservas")
public class ReservaController
{
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService)
    {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Listar todas las reservas")
    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodas()
    {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @Operation(summary = "Buscar una reserva por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id)
    {
        ReservaResponseDTO dto = reservaService.findById(id);

        if (dto == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Crear una nueva reserva")
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody ReservaRequestDTO dto)
    {
        ReservaResponseDTO resultado = reservaService.save(dto);

        if (resultado == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo crear la reserva. Verifique que el pasajeroId y el vueloId existan.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @Operation(summary = "Actualizar una reserva existente")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaRequestDTO dto)
    {
        ReservaResponseDTO resultado = reservaService.update(id, dto);

        if (resultado == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo actualizar la reserva. Verifique que el ID de la reserva, pasajeroId y vueloId existan.");
        }

        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Eliminar una reserva por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id)
    {
        ReservaResponseDTO dto = reservaService.findById(id);

        if (dto == null)
        {
            return ResponseEntity.notFound().build();
        }

        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
