package comercio_exterior_rastreador.controller;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Pedido;
import comercio_exterior_rastreador.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(path = "/listadoPedidos")
    public ResponseEntity<Flux<Pedido>> listaPedidos(){
        return new ResponseEntity<>(pedidoService.listaPedidos(), HttpStatus.OK);
    }
    @PostMapping(path = "/registrar")
    public ResponseEntity<Mono<Void>> registrarPedido(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoService.savePedido(pedido), HttpStatus.OK);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Mono<Pedido>> actualizarPedido(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoService.updatePedido(pedido), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Mono<ResponseEntity<Pedido>> eliminar(@PathVariable("id") String id){
        return pedidoService.deletePedido(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .switchIfEmpty(Mono.just(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}
