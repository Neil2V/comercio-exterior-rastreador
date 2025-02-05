package comercio_exterior_rastreador.service.impl;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.BodyInserters;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Value("${url1}")
    String url1;
    @Autowired
    WebClient.Builder builder;

    @Override
    public Mono<Cliente> saveCliente(Cliente cliente) {
        return builder.build()
                .post()
                .uri(url1 + "/api/clientes/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cliente))
                .retrieve()
                .bodyToMono(Cliente.class);
    }

    @Override
    public Mono<Cliente> updateCliente(Cliente cliente) {
        return builder.build()
                .put()
                .uri(url1 + "/api/clientes/actualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cliente))
                .retrieve()
                .bodyToMono(Cliente.class);
    }

    @Override
    public Mono<Cliente> deleteCliente(Integer idCliente) {
        return builder.build()
                .delete()
                .uri(url1 + "/api/clientes/delete/"+idCliente)
                .retrieve()
                .bodyToMono(Cliente.class);
    }

    @Override
    public Flux<Cliente> listaClientes() {
        return builder.build()
                .get()
                .uri(url1+"/api/clientes/findAll")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Cliente.class)
                .map(e -> e);
    }
}
