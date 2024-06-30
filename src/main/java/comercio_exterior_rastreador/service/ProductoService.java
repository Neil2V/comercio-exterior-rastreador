package comercio_exterior_rastreador.service;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    Flux<Producto> listaProductos();

    Mono<Producto> saveProducto(Producto producto);

    Mono<Producto> updateProducto(Producto producto);

    Mono<Producto> deleteProducto(Integer idProducto);
}
