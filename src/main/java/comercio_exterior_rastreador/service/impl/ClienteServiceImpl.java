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

@Service
public class ClienteServiceImpl implements ClienteService {

    @Value("${url1}")
    String url1;

    @Value("${url2}")
    String url2;
    @Autowired
    WebClient.Builder builder;
    @Override
    public Mono<Void> saveCliente(Cliente cliente) {
        return null;
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
