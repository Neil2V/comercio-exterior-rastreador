package comercio_exterior_rastreador.service;

import comercio_exterior_rastreador.entity.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Cliente> saveCliente(Cliente cliente);

    Mono<Cliente> updateCliente(Cliente cliente);


    Flux<Cliente> listaClientes();
}
