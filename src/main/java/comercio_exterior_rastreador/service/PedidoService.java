package comercio_exterior_rastreador.service;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Pedido;
import reactor.core.publisher.Mono;

public interface PedidoService {

    Mono<Void> savePedido(Pedido pedido);

}
