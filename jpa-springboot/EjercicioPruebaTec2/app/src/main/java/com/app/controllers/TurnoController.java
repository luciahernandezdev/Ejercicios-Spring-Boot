package com.app.controllers;

import com.app.dtos.TurnoDTO;
import com.app.services.TurnoServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    // Inyectar la dependencia de un servicio
    @Autowired
    TurnoServicioInterfaz service;

    @GetMapping({"/", ""})
    public ResponseEntity<List<TurnoDTO>> obtenerTodosLosTurnos(){
        List<TurnoDTO> listado = service.buscarTodos();
        return ResponseEntity.status(200).body(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> obtenerTurnoPorID(@PathVariable Long id){
        TurnoDTO turnoEncontrado = service.buscarPorId(id);
        return ResponseEntity.status(200).body(turnoEncontrado);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<TurnoDTO> guardarTurno(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO turnoGuardado = service.crear(turnoDTO);
        return ResponseEntity.status(201).body(turnoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> actualizarTurno(@PathVariable Long id, @RequestBody TurnoDTO turnoDTO){
        TurnoDTO turnoActualizado = service.actualizar(id, turnoDTO);
        return ResponseEntity.ok(turnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<TurnoDTO>> eliminarTurno(@PathVariable Long id){
        List<TurnoDTO> listado = service.eliminar(id);
        return ResponseEntity.ok(listado);
    }
}