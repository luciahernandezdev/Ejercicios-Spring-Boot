package app.services;

import app.dtos.PilotoDTO;
import app.models.Equipo;
import app.models.Piloto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetenciaService {
    List<Equipo> obtenerEquipos();
    List<Piloto> obtenerPilotos();
    Equipo obtenerEquipoPorNombre(String nombreEquipo);
    List<PilotoDTO> obtenerPilotosPorEquipo(String nombreEquipo);
    void agregarEquipo(Equipo equipo);
    void agregarPiloto(Piloto piloto, String nombreEquipo); // Modificar para agregar piloto a equipo específico
}
