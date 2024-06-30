package comercio_exterior_rastreador.service;

import comercio_exterior_rastreador.entity.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Void> saveCliente(Cliente cliente);

    Flux<Cliente> listaClientes();
}
