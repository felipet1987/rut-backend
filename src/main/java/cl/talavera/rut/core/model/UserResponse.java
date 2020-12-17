package cl.talavera.rut.core.model;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserResponse {
    private String nombre;
    private String apellido;
    private String fechaNac;
}
