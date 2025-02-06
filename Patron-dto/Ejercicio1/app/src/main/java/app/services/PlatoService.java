package app.services;

import app.dtos.PlatoDTO;

import java.util.List;

public interface PlatoService {
    PlatoDTO obtenerPlatoPorId(Long id);
    List<PlatoDTO> obtenerTodosLosPlatos();
}
