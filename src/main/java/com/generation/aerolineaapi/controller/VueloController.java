package com.generation.aerolineaapi.controller;

import com.generation.aerolineaapi.model.Vuelo;
import com.generation.aerolineaapi.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vuelos", description = "Gestión de los vuelos de la aerolínea")
@RestController
@RequestMapping("/vuelos")
public class VueloController
{
    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService)
    {
        this.vueloService = vueloService;
    }

    @Operation(summary = "Listar todos los vuelos")
    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos()
    {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @Operation(summary = "Buscar un vuelo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id)
    {
        Vuelo vuelo = vueloService.findById(id);

        if (vuelo == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vuelo);
    }

    @Operation(summary = "Crear un nuevo vuelo")
    @PostMapping
    public ResponseEntity<Vuelo> crear(@Valid @RequestBody Vuelo vuelo)
    {
        Vuelo nuevoVuelo = vueloService.save(vuelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVuelo);
    }

    @Operation(summary = "Actualizar un vuelo existente")
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @Valid @RequestBody Vuelo vuelo)
    {
        Vuelo actualizado = vueloService.update(id, vuelo);

        if (actualizado == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Eliminar un vuelo por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id)
    {
        Vuelo existente = vueloService.findById(id);

        if (existente == null)
        {
            return ResponseEntity.notFound().build();
        }

        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
