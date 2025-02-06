package app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDTO {

    @JsonProperty("platoId")
    private Long id;

    @JsonProperty("platoNombre")
    private String nombre;

    @JsonProperty("aptoCeliaco")
    private boolean aptoCeliaco;
}
