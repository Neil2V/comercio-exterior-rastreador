package comercio_exterior_rastreador.service.impl;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Pedido;
import comercio_exterior_rastreador.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService {

    @Value("${url2}")
    String url2;
    @Autowired
    WebClient.Builder builder;

    /*@Override
    public Mono<Void> savePedido(Pedido pedido) {
        return builder.build()
                .post()
                .uri(url2 + "/api/pedidos/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(pedido))
                .retrieve()
                .bodyToMono(Void.class);
    }*/

    @Override
    public Mono<Void> savePedido(Pedido pedido) {
        return builder.build()
                .post()
                .uri(url2 + "/api/pedidos/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(pedido))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(response -> {
                    log.info("Respuesta del servidor al guardar pedido: {}", response);
                    return Mono.empty();
                });
    }
}
