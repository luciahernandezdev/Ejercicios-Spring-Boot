package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    private Long id;
    private String nombre;
    private String pais;
    private List<Piloto> pilotos;

}
