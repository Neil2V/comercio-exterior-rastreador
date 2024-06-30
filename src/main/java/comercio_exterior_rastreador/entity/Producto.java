package comercio_exterior_rastreador.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Producto {
    private Integer idProducto;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String categoria;
    private Integer cantidad;
    private Integer stock;
    private String imagen;
    private LocalDateTime fchRegistro;
}
