package com.generation.aerolineaapi.controller;

import com.generation.aerolineaapi.model.Pasajero;
import com.generation.aerolineaapi.service.PasajeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pasajeros", description = "Gestión de los pasajeros de la aerolínea")
@RestController
@RequestMapping("/pasajeros")
public class PasajeroController
{
    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService)
    {
        this.pasajeroService = pasajeroService;
    }

    @Operation(summary = "Listar todos los pasajeros")
    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos()
    {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @Operation(summary = "Buscar un pasajero por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id)
    {
        Pasajero pasajero = pasajeroService.findById(id);

        if (pasajero == null)
        {
            return ResponseEntity.notFound().build(); // Retorna 404 si no existe
        }

        return ResponseEntity.ok(pasajero);
    }

    @Operation(summary = "Crear un nuevo pasajero")
    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero)
    {
        Pasajero nuevoPasajero = pasajeroService.save(pasajero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPasajero); // Retorna 201 Created
    }

    @Operation(summary = "Actualizar un pasajero existente")
    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizar(@PathVariable Long id, @Valid @RequestBody Pasajero pasajero)
    {
        Pasajero actualizado = pasajeroService.update(id, pasajero);

        if (actualizado == null)
        {
            return ResponseEntity.notFound().build(); // Retorna 404 si el ID no existe
        }

        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Eliminar un pasajero por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id)
    {
        Pasajero existente = pasajeroService.findById(id);

        if (existente == null)
        {
            return ResponseEntity.notFound().build(); // Retorna 404 si no existe
        }

        pasajeroService.delete(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
