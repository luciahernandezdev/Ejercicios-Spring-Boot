package app.controllers;

import app.dtos.PlatoDTO;
import app.services.PlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDTO> obtenerPlatoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(platoService.obtenerPlatoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PlatoDTO>> obtenerTodosLosPlatos() {
        return ResponseEntity.ok(platoService.obtenerTodosLosPlatos());
    }
}
