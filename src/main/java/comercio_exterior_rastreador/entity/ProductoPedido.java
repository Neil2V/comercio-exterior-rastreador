package comercio_exterior_rastreador.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoPedido {
    private Integer idProducto;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String categoria;
    private Integer cantidad;
}
