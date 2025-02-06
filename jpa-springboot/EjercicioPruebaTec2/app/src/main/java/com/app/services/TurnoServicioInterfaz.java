package com.app.services;

import com.app.dtos.TurnoDTO;
import com.app.entities.Turno;

import java.util.List;

public interface TurnoServicioInterfaz {
    List<TurnoDTO> buscarTodos();
    TurnoDTO buscarPorId(Long id);
    TurnoDTO crear(TurnoDTO turnoDTO);
    TurnoDTO actualizar(Long id, TurnoDTO turnoDTO);
    List<TurnoDTO> eliminar(Long id);

    //convertidores
    TurnoDTO mapToDTO(Turno turno);
    Turno mapToEntity(TurnoDTO turnoDTO);
}
