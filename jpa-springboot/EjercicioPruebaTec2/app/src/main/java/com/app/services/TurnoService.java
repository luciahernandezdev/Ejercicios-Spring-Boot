package com.app.services;

import com.app.dtos.TurnoDTO;
import com.app.entities.Ciudadano;
import com.app.entities.Turno;
import com.app.repositories.CiudadanoRepositorioInterfaz;
import com.app.repositories.TurnoRepositorioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoService implements TurnoServicioInterfaz {

    @Autowired
    private TurnoRepositorioInterfaz turnoRepository;

    @Autowired
    private CiudadanoRepositorioInterfaz ciudadanoRepository;


    @Override
    public List<TurnoDTO> buscarTodos() {
        return turnoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TurnoDTO buscarPorId(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        return turno.map(this::mapToDTO).orElse(null);
    }

    @Override
    public TurnoDTO crear(TurnoDTO turnoDTO) {
        Turno turno = mapToEntity(turnoDTO);
        Turno nuevoTurno = turnoRepository.save(turno);
        return mapToDTO(nuevoTurno);
    }

    @Override
    public TurnoDTO actualizar(Long id, TurnoDTO turnoDTO) {
        Optional<Turno> turnoExistente = turnoRepository.findById(id);
        if (turnoExistente.isPresent()) {
            Turno turno = mapToEntity(turnoDTO);
            turno.setId(id);
            Turno turnoActualizado = turnoRepository.save(turno);
            return mapToDTO(turnoActualizado);
        }
        return null;
    }

    @Override
    public List<TurnoDTO> eliminar(Long id) {
        turnoRepository.deleteById(id);
        return buscarTodos();
    }

    @Override
    public TurnoDTO mapToDTO(Turno turno) {
        return new TurnoDTO(
                turno.getId(),
                turno.getFecha(),
                turno.getDescripcion(),
                turno.getEstado().name(),
                turno.getCiudadano().getId(),
                turno.getCiudadano().getNombre(),
                turno.getCiudadano().getApellido()
        );
    }

    @Override
    public Turno mapToEntity(TurnoDTO turnoDTO) {
        Ciudadano ciudadano = ciudadanoRepository.findById(turnoDTO.getCiudadanoId())
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado con ID: " + turnoDTO.getCiudadanoId())).getCiudadano();
        return new Turno(
                turnoDTO.getId(),
                turnoDTO.getFecha(),
                turnoDTO.getDescripcion(),
                Turno.EstadoTurno.valueOf(turnoDTO.getEstado()),
                ciudadano);
    }
}