package comercio_exterior_rastreador.controller;

import comercio_exterior_rastreador.entity.Cliente;
import comercio_exterior_rastreador.entity.Pedido;
import comercio_exterior_rastreador.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(path = "/registrar")
    public ResponseEntity<Mono<Void>> registrarCliente(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoService.savePedido(pedido), HttpStatus.OK);
    }
}
