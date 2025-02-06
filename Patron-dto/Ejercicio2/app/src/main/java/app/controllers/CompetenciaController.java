package app.controllers;

import app.dtos.PilotoDTO;
import app.models.Equipo;
import app.models.Piloto;
import app.services.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia")
public class CompetenciaController {
    @Autowired
    private CompetenciaService competenciaService;

    @GetMapping("/equipos/traer")
    public ResponseEntity<List<Equipo>> traerEquipos() {
        return ResponseEntity.ok(competenciaService.obtenerEquipos());
    }

    @GetMapping("/pilotos/traer")
    public ResponseEntity<List<Piloto>> traerPilotos() {
        return ResponseEntity.ok(competenciaService.obtenerPilotos());
    }

    @GetMapping("/equipos/traer/{nombreEquipo}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable String nombreEquipo) {
        return ResponseEntity.ok(competenciaService.obtenerEquipoPorNombre(nombreEquipo));
    }

    @GetMapping("/pilotos/traer/{nombreEquipo}")
    public ResponseEntity<List<PilotoDTO>> obtenerPilotosPorEquipo(@PathVariable String nombreEquipo) {
        return ResponseEntity.ok(competenciaService.obtenerPilotosPorEquipo(nombreEquipo));
    }

    @PostMapping("/equipos")
    public ResponseEntity<Void> agregarEquipo(@RequestBody Equipo equipo) {
        competenciaService.agregarEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/pilotos/{nombreEquipo}")
    public ResponseEntity<Void> agregarPiloto(@RequestBody Piloto piloto, @PathVariable String nombreEquipo) {
        competenciaService.agregarPiloto(piloto, nombreEquipo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}