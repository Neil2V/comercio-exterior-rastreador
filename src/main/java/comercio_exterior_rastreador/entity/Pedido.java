package comercio_exterior_rastreador.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Pedido {
    private String id;
    private String estado;
    private Cliente cliente;
    private List<ProductoPedido> productos;
    private Integer total;
    private LocalDate fchRegistro;
}
