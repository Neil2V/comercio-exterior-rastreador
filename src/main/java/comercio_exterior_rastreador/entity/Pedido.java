package comercio_exterior_rastreador.entity;

import lombok.Data;

import java.util.List;

@Data
public class Pedido {
    private Integer idPedido;
    private String nroPedido;
    private String estado;
    private Cliente cliente;
    private List<Producto> productos;
    private Integer total;
}
