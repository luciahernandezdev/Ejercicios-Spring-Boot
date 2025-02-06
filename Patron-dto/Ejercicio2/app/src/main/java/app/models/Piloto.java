package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera automáticamente los métodos getters, setters, toString(), equals(), y hashCode().
@NoArgsConstructor //Genera un constructor vacío, útil para deserialización en frameworks como Spring Boot.
@AllArgsConstructor //genera un constructor con todos los atributos.
public class Piloto {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;

}
