package app.services;

import app.dtos.PilotoDTO;
import app.models.Equipo;
import app.models.Piloto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenciaServiceImpl implements CompetenciaService {
    private List<Equipo> listaEquipos = new ArrayList<>();
    private List<Piloto> listaPilotos = new ArrayList<>();

    public CompetenciaServiceImpl() {
        // Inicializamos equipos
        listaEquipos.add(new Equipo(1L, "Ferrari", "Italia", new ArrayList<>()));
        listaEquipos.add(new Equipo(2L, "Alpine", "Francia", new ArrayList<>()));
        listaEquipos.add(new Equipo(3L, "McLaren", "Inglaterra", new ArrayList<>()));

        // Inicializamos pilotos y los añadimos a los equipos correspondientes
        Piloto sainz = new Piloto(1L, "Carlos", "Sainz", 28, "España");
        Piloto leclerc = new Piloto(2L, "Charles", "Leclerc", 25, "Mónaco");
        Piloto ocon = new Piloto(3L, "Esteban", "Ocon", 28, "Francia");
        Piloto norris = new Piloto(4L, "Lando", "Norris", 24, "Reino Unido");

        listaPilotos.add(sainz);
        listaPilotos.add(leclerc);
        listaPilotos.add(ocon);
        listaPilotos.add(norris);

        listaEquipos.get(0).getPilotos().add(sainz);
        listaEquipos.get(0).getPilotos().add(leclerc);
        listaEquipos.get(1).getPilotos().add(ocon);
        listaEquipos.get(2).getPilotos().add(norris);
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        return listaEquipos;
    }

    @Override
    public List<Piloto> obtenerPilotos() {
        return listaPilotos;
    }

    @Override
    public Equipo obtenerEquipoPorNombre(String nombreEquipo) {
        return listaEquipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PilotoDTO> obtenerPilotosPorEquipo(String nombreEquipo) {
        return listaEquipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))
                .flatMap(equipo -> equipo.getPilotos().stream())
                .map(piloto -> new PilotoDTO(piloto.getNombre(), piloto.getApellido(), nombreEquipo))
                .collect(Collectors.toList());
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    @Override
    public void agregarPiloto(Piloto piloto, String nombreEquipo) {
        Equipo equipo = obtenerEquipoPorNombre(nombreEquipo);
        if (equipo != null) {
            equipo.getPilotos().add(piloto);
            listaPilotos.add(piloto);
        }
    }
}