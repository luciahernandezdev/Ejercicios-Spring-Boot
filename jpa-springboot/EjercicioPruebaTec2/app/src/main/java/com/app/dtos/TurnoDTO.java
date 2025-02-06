package com.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("estado")
    private String estado; //ESPERA o ATENDIDO

    @JsonProperty("ciudadano_id")
    private Long ciudadanoId;

    @JsonProperty("ciudadano_nombre")
    private String ciudadanoNombre;

    @JsonProperty("ciudadano_apellido")
    private String ciudadanoApellido;

}
