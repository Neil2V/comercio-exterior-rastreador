package comercio_exterior_rastreador.controller;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Producto;
import comercio_exterior_rastreador.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(path = "/listadoProductos")
    public ResponseEntity<Flux<Producto>> listaProductos(){
        return new ResponseEntity<>(productoService.listaProductos(), HttpStatus.OK);
    }

    @PostMapping(path = "/registrar")
    public ResponseEntity<Mono<Producto>> registrarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.saveProducto(producto), HttpStatus.OK);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Mono<Producto>> actualizarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.updateProducto(producto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{idProducto}")
    public Mono<ResponseEntity<Producto>> eliminar(@PathVariable("idProducto") Integer idProducto){
        return productoService.deleteProducto(idProducto)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}
