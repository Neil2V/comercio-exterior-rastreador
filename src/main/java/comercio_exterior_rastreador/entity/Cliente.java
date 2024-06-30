package comercio_exterior_rastreador.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Cliente {

    private Integer idCliente;
    private LocalDate fchRegistro;
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;
}
