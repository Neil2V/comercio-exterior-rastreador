package comercio_exterior_rastreador.service.impl;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Producto;
import comercio_exterior_rastreador.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Value("${url1}")
    String url1;
    @Autowired
    WebClient.Builder builder;

    @Override
    public Flux<Producto> listaProductos() {
        return builder.build()
                .get()
                .uri(url1+"/api/productos/findAll")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class)
                .map(e -> e);
    }

    @Override
    public Mono<Producto> saveProducto(Producto producto) {
        return builder.build()
                .post()
                .uri(url1 + "/api/productos/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(producto))
                .retrieve()
                .bodyToMono(Producto.class);
    }

    @Override
    public Mono<Producto> updateProducto(Producto producto) {
        return builder.build()
                .put()
                .uri(url1 + "/api/productos/actualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(producto))
                .retrieve()
                .bodyToMono(Producto.class);
    }

    @Override
    public Mono<Producto> deleteProducto(Integer idProducto) {
        return builder.build()
                .delete()
                .uri(url1 + "/api/productos/delete/"+idProducto)
                .retrieve()
                .bodyToMono(Producto.class);
    }
}
