package app.services;

import app.dtos.PlatoDTO;
import app.models.Ingrediente;
import app.models.Plato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoService {

    private List<Plato> platos = List.of(

            new Plato(1L, "Ensalada César", 10.0, List.of(
                    new Ingrediente(1L, "Lechuga", true),
                    new Ingrediente(2L, "Pollo", true),
                    new Ingrediente(3L, "Picatostes", false),
                    new Ingrediente(4L, "Queso parmesano", true)
            )),
            new Plato(2L, "Tortilla de Patatas", 12.0, List.of(
                    new Ingrediente(5L, "Patata", true),
                    new Ingrediente(6L, "Huevo", true),
                    new Ingrediente(7L, "Cebolla", true),
                    new Ingrediente(8L, "Aceite de oliva", true)
            )),
            new Plato(3L, "Paella", 20.0, List.of(
                    new Ingrediente(9L, "Arroz", true),
                    new Ingrediente(10L, "Pollo", true),
                    new Ingrediente(11L, "Judía verde", true),
                    new Ingrediente(12L, "Tomate", true),
                    new Ingrediente(13L, "Azafrán", true)
            )),
            new Plato(4L, "Pulpo a la Gallega", 22.0, List.of(
                    new Ingrediente(14L, "Pulpo", true),
                    new Ingrediente(15L, "Patata", true),
                    new Ingrediente(16L, "Pimentón", true),
                    new Ingrediente(17L, "Aceite de oliva", true)
            )),
            new Plato(5L, "Fabada", 10.0, List.of(
                    new Ingrediente(18L, "Alubias blancas", true),
                    new Ingrediente(19L, "Chorizo", true),
                    new Ingrediente(20L, "Morcilla", true),
                    new Ingrediente(21L, "Panceta", true)
            )),
            new Plato(6L, "Cocido", 15.0, List.of(
                    new Ingrediente(22L, "Garbanzos", true),
                    new Ingrediente(23L, "Carne de ternera", true),
                    new Ingrediente(24L, "Chorizo", true),
                    new Ingrediente(25L, "Tocino", true),
                    new Ingrediente(26L, "Repollo", true)
            )),
            new Plato(7L, "Pisto", 12.0, List.of(
                    new Ingrediente(27L, "Tomate", true),
                    new Ingrediente(28L, "Pimiento rojo", true),
                    new Ingrediente(29L, "Calabacín", true),
                    new Ingrediente(30L, "Cebolla", true),
                    new Ingrediente(31L, "Aceite de oliva", true)
            )),
            new Plato(8L, "Croquetas de Jamón", 16.0, List.of(
                    new Ingrediente(32L, "Jamón", true),
                    new Ingrediente(33L, "Harina", false),
                    new Ingrediente(34L, "Leche", true),
                    new Ingrediente(35L, "Aceite", true)
            ))
    );

    @Override
    public PlatoDTO obtenerPlatoPorId(Long id) {
        // Buscamos el plato por su ID dentro de la lista de platos
        return platos.stream()
                .filter(plato -> plato.getId().equals(id)) //Filtramos por ID
                .findFirst() //Coge el primer plato que coincide con el ID
                .map(this::convertirAPlatoDTO) //Si encuentra el plato, lo convierte a DTO.
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id)); //Si no lo encontramos, lanza la excepción
    }

    @Override
    public List<PlatoDTO> obtenerTodosLosPlatos() {
        return platos.stream()
                .map(this::convertirAPlatoDTO)
                .collect(Collectors.toList());
    }

    private PlatoDTO convertirAPlatoDTO(Plato plato) {
        //Verifica si todos los ingredientes del plato son aptos
        boolean aptoCeliaco = plato.getIngredientes().stream()
                .allMatch(Ingrediente::isAptoCeliaco); //Si un ingrediente no es apto, el plato no es apto
        //Devuelve ID, nombre y apto del plato
        return new PlatoDTO(plato.getId(), plato.getNombre(), aptoCeliaco);
    }
}
